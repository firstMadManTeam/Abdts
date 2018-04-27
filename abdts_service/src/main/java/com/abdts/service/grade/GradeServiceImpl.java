package com.abdts.service.grade;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.grade.GradeDao;
import com.abdts.entity.grade.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List<Grade> getGrades(DataKeyPair dataKeyPair) {
        return gradeDao.getGrades(dataKeyPair);
    }
}
