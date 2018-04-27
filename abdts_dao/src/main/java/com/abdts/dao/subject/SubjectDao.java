package com.abdts.dao.subject;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.subject.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pzy
 */
@Mapper
public interface SubjectDao {

    List<Subject> getSubjectList(DataKeyPair dataKeyPair);

    Integer addSubject(DataKeyPair dataKeyPair);

    Integer removeSubject(DataKeyPair dataKeyPair);

}
