package com.abdts.dao.student;

import com.abdts.entity.student.StudentClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pzy
 */
@Mapper
public interface StudentClassDao {

    List<StudentClass> getStudentClass();

}
