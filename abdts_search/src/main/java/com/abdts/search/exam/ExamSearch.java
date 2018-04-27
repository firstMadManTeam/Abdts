package com.abdts.search.exam;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.grade.Grade;
import com.abdts.search.student.StudentListSearch;
import com.abdts.service.exam.ExamService;
import com.abdts.vo.exam.ExamVO;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pzy
 */
@RestController
@RequestMapping("/exam")
public class ExamSearch extends BaseController {

    private Logger logger = Logger.getLogger(StudentListSearch.class);

    @Resource
    private ExamService examService;

    @RequestMapping(value = "/getExamList", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public List<ExamVO> getExamList() {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        return examService.getExams(dataKeyPair);
    }

    @RequestMapping(value = "/getExamCount", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public Integer getExamCount() {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        return examService.getExamCount(dataKeyPair);
    }

}
