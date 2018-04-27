package com.abdts.service.exam;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.exam.ExamDao;
import com.abdts.entity.exam.Exam;
import com.abdts.vo.exam.ExamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDao examDao;

    @Override
    public List<ExamVO> getExams(DataKeyPair dataKeyPair) {
        return examDao.getExams(dataKeyPair);
    }

    @Override
    public Integer addExam(DataKeyPair dataKeyPair) {
        return examDao.addExam(dataKeyPair);
    }

    @Override
    public Integer delExam(DataKeyPair dataKeyPair) {
        return examDao.delExam(dataKeyPair);
    }

    @Override
    public Integer updExam(DataKeyPair dataKeyPair) {
        return examDao.updExam(dataKeyPair);
    }

    @Override
    public Integer getExamCount(DataKeyPair dataKeyPair) {
        return examDao.getExamCount(dataKeyPair);
    }
}
