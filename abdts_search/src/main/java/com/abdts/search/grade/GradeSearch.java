package com.abdts.search.grade;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.grade.Grade;
import com.abdts.search.student.StudentListSearch;
import com.abdts.service.grade.GradeService;
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
@RequestMapping("/grade")
public class GradeSearch extends BaseController {

    private Logger logger = Logger.getLogger(StudentListSearch.class);

    @Resource
    private GradeService gradeService;

    @RequestMapping(value = "/getGrades", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public List<Grade> getGrades() {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        return gradeService.getGrades(dataKeyPair);
    }

}
