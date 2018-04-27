package com.abdts.service.grade;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.grade.Grade;

import java.util.List;

/**
 * @author pzy
 */
public interface GradeService {

    List<Grade> getGrades(DataKeyPair dataKeyPair);

}
