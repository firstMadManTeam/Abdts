package com.abdts.search.student;

import com.abdts.entity.student.StudentClass;
import com.abdts.service.student.StudentClassService;
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
@RequestMapping("/stuClass")
public class StudentClassSearch {

    private Logger logger = Logger.getLogger(StudentListSearch.class);

    @Resource
    private StudentClassService studentClassService;

    @RequestMapping(value = "/getAll", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public List<StudentClass> getAll() throws Exception {
        return studentClassService.getStudentClass();
    }


}
