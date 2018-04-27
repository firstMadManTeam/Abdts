package com.abdts.service.student;

import com.abdts.dao.student.StudentClassDao;
import com.abdts.entity.student.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class StudentClassServiceImpl implements StudentClassService{

    @Autowired
    private StudentClassDao studentClassDao;

    @Override
    public List<StudentClass> getStudentClass() {
        return studentClassDao.getStudentClass();
    }
}
