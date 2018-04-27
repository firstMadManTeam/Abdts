package com.abdts.search.student;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.common.util.SolrUtil;
import com.abdts.common.util.StuChoose;
import com.abdts.vo.student.StudentListVO;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pzy
 */
@RestController
@RequestMapping("/stuList")
public class StudentListSearch extends BaseController {

    private SolrQuery solrQuery = null;
    private HttpSolrServer solrServer = null;
    private QueryResponse response = null;
    private SolrDocumentList solrDocuments = null;

    private Logger logger = Logger.getLogger(StudentListSearch.class);

    @RequestMapping(value = "/findNameStuList", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public List<StudentListVO> findNameStuList() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        solrSel(dataKeyPair);
        solrQuery.setRows(20);
        if (dataKeyPair.containsKey("rows")) {
            if (dataKeyPair.containsKey("start") && dataKeyPair.getInt("start") > 0) {
                solrQuery.setStart(dataKeyPair.getInt("rows") * (dataKeyPair.getInt("start") - 1));
            }
            solrQuery.setRows(dataKeyPair.getInt("rows"));
        }
        //执行查询
        response = solrServer.query(solrQuery);
        SolrDocumentList solrDocuments = response.getResults();
        logger.debug("查询结果的总数量：" + solrDocuments.getNumFound());
        //获取集合
        List<StudentListVO> listVOS = response.getBeans(StudentListVO.class);
        List<StudentListVO> stuVOS = new ArrayList<>();
        for (StudentListVO listVO : listVOS) {
            listVO.setStuSex(StuChoose.getSex(listVO.getStudent_sex()));
            listVO.setStuState(StuChoose.getState(listVO.getStudent_state()));
            //重新添加到集合
            stuVOS.add(listVO);
        }
        return stuVOS;
    }

    @RequestMapping(value = "/getCount", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public long getCount() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        solrSel(dataKeyPair);
        //执行查询
        response = solrServer.query(solrQuery);
        SolrDocumentList solrDocuments = response.getResults();
        logger.debug("查询结果的总数量：" + solrDocuments.getNumFound());
        dataKeyPair.clear();
        long count = solrDocuments.getNumFound() % 20 == 0 ? solrDocuments.getNumFound() / 20 : solrDocuments.getNumFound() / 20 + 1;
        List<Integer> counts = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            counts.add(i);
        }
        return count;
    }

    @RequestMapping(value = "/getIndexCount", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public Long getIndexCount() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        solrQuery = new SolrQuery();
        solrServer = SolrUtil.getSolrServer("abdts_studentlist");
        //查询全部
        solrQuery.setQuery("*:*");
        //执行查询
        response = solrServer.query(solrQuery);
        SolrDocumentList solrDocuments = response.getResults();
        logger.debug("查询结果的总数量：" + solrDocuments.getNumFound());
        dataKeyPair.clear();
        return solrDocuments.getNumFound();
    }

    @RequestMapping(value = "/findById", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public StudentListVO findById() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        solrQuery = new SolrQuery();
        solrServer = SolrUtil.getSolrServer("abdts_studentlist");
        solrQuery.setQuery("student_id:" + dataKeyPair.get("student_id"));
        //执行查询
        response = solrServer.query(solrQuery);
        SolrDocumentList solrDocuments = response.getResults();
        logger.debug("查询结果的总数量：" + solrDocuments.getNumFound());
        //获取集合
        StudentListVO listVOS = response.getBeans(StudentListVO.class).get(0);
        StudentListVO stuVOS = new StudentListVO();
        stuVOS = listVOS;
        stuVOS.setStuSex(StuChoose.getSex(listVOS.getStudent_sex()));
        stuVOS.setStuState(StuChoose.getState(listVOS.getStudent_state()));
        //重新添加到集合
        return stuVOS;
    }

    /**
     * 公共模块提取
     *
     * @param dataKeyPair 入参 map
     */
    private void solrSel(DataKeyPair dataKeyPair) {
        solrQuery = new SolrQuery();
        solrServer = SolrUtil.getSolrServer("abdts_studentlist");
        // 创建组合条件串
        StringBuilder params = new StringBuilder();
        //判断键存不存在
        if (dataKeyPair.containsKey("studentName") && dataKeyPair.containsKey("classId")) {
            //班级
            Integer classId = 0;
            if (!dataKeyPair.getString("classId").isEmpty()) {
                classId = dataKeyPair.getInt("classId");
            }
            if (classId != 0 && !dataKeyPair.getString("studentName").isEmpty()) {
                params.append(" student_name:" + dataKeyPair.getString("studentName"));
                params.append(" AND student_classid:" + dataKeyPair.getString("classId"));
                solrQuery.setQuery(params.toString());
            } else if (classId != 0) {
                params.append(" student_classid:" + dataKeyPair.getString("classId"));
                solrQuery.setQuery(params.toString());
            } else if (!dataKeyPair.getString("studentName").isEmpty()) {
                solrQuery.setQuery("student_name:" + dataKeyPair.getString("studentName"));
            } else {
                //查询全部
                solrQuery.setQuery("*:*");
            }
        } else if (dataKeyPair.containsKey("studentName")) {
            solrQuery.setQuery("student_name:" + dataKeyPair.getString("studentName"));
        } else if (dataKeyPair.containsKey("classId")) {
            if (dataKeyPair.getInt("classId") > 0) {
                solrQuery.setQuery("student_classid:" + dataKeyPair.getString("classId"));
            } else {
                //查询全部
                solrQuery.setQuery("*:*");
            }
        } else {
            //查询全部
            solrQuery.setQuery("*:*");
        }
    }

}
