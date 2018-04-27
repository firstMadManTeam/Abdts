package com.abdts.controller.student;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.service.student.StudentListService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author pzy
 */
@RestController
@RequestMapping("/stuList")
public class StudentListController extends BaseController {

    @Resource
    private StudentListService studentListService;

    private Logger logger = Logger.getLogger(StudentListController.class);

    @RequestMapping(value = "/delStuList", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public DataKeyPair delStuList() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        //删除操作
        boolean flag = studentListService.delStuList(dataKeyPair);
        logger.info("删除结果" + flag);
        //清空map
        dataKeyPair.clear();
        if (flag) {
            dataKeyPair.put("rel", flag);
            dataKeyPair.put("smg", "删除成功！");
        } else {
            dataKeyPair.put("rel", flag);
            dataKeyPair.put("smg", "删除失败！");
        }
        return dataKeyPair;
    }

    @RequestMapping(value = "/addStuList",
            method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public DataKeyPair addStuList() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        dataKeyPair.put("student_modifytime", new Date());
        dataKeyPair.put("student_modifyteacher", "默认");
        dataKeyPair.put("student_state", 1);
        dataKeyPair.put("student_identity", 2);
        if (!dataKeyPair.containsKey("student_name") || dataKeyPair.getString("student_name") == null) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("msg", "姓名不能为空！");
            return dataKeyPair;
        } else if (!dataKeyPair.containsKey("student_sex") || dataKeyPair.getInt("student_sex") == null ||
                dataKeyPair.getInt("student_sex") <= 0) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("msg", "性别不能为空！");
            return dataKeyPair;
        } else if (!dataKeyPair.containsKey("student_age") || dataKeyPair.getInt("student_age") == null ||
                dataKeyPair.getInt("student_age") <= 0) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("msg", "年龄不能为空,必须大于0！");
            return dataKeyPair;
        } else if (!dataKeyPair.containsKey("student_gradeid") || dataKeyPair.getInt("student_gradeid") == null ||
                dataKeyPair.getInt("student_gradeid") <= 0) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("msg", "年级不能为空！");
            return dataKeyPair;
        } else if (!dataKeyPair.containsKey("student_classid") || dataKeyPair.getInt("student_classid") == null ||
                dataKeyPair.getInt("student_classid") <= 0) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("msg", "班级不能为空！");
            return dataKeyPair;
        } else if (!dataKeyPair.containsKey("student_birthday") || dataKeyPair.getString("student_birthday") == null) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("msg", "出生不能为空！");
            return dataKeyPair;
        }
        //添加操作
        boolean flag = studentListService.addStuList(dataKeyPair);
        logger.info("添加结果" + flag);
        //清空map
        dataKeyPair.clear();
        if (flag) {
            dataKeyPair.put("rel", flag);
            dataKeyPair.put("smg", "添加成功!");
        } else {
            dataKeyPair.put("rel", flag);
            dataKeyPair.put("smg", "添加失败！");
        }
        return dataKeyPair;
    }

    @RequestMapping(value = "/updStuList", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public DataKeyPair updStuList() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        dataKeyPair.put("student_modifytime", new Date());
        //修改操作
        boolean flag = studentListService.updStuList(dataKeyPair);
        logger.info("修改结果" + flag);
        //清空map
        dataKeyPair.clear();
        if (flag) {
            dataKeyPair.put("rel", flag);
            dataKeyPair.put("smg", "修改成功！");
        } else {
            dataKeyPair.put("rel", flag);
            dataKeyPair.put("smg", "修改失败！");
        }
        return dataKeyPair;
    }

}
