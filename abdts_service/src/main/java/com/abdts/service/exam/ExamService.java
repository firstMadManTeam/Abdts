package com.abdts.service.exam;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.exam.Exam;
import com.abdts.vo.exam.ExamVO;

import java.util.List;

/**
 * @author pzy
 */
public interface ExamService {

    List<ExamVO> getExams(DataKeyPair dataKeyPair);

    Integer addExam(DataKeyPair dataKeyPair);

    Integer delExam(DataKeyPair dataKeyPair);

    Integer updExam(DataKeyPair dataKeyPair);

    Integer getExamCount(DataKeyPair dataKeyPair);

}
