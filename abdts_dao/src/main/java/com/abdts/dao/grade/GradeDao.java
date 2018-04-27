package com.abdts.dao.grade;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.grade.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author pzy
 */
@Mapper
public interface GradeDao {

    List<Grade> getGrades(DataKeyPair dataKeyPair);

}
