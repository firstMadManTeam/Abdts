package com.abdts.dao.exam;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.exam.Exam;
import com.abdts.vo.exam.ExamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pzy
 */
@Mapper
public interface ExamDao {

    List<ExamVO> getExams(DataKeyPair dataKeyPair);

    Integer addExam(DataKeyPair dataKeyPair);

    Integer delExam(DataKeyPair dataKeyPair);

    Integer updExam(DataKeyPair dataKeyPair);

    Integer getExamCount(DataKeyPair dataKeyPair);

}
