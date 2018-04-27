package com.abdts.service.subject;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.subject.Subject;

import java.util.List;

/**
 * @author pzy
 */
public interface SubjectService {

    List<Subject> getSubjectList(DataKeyPair dataKeyPair);

    Integer addSubject(DataKeyPair dataKeyPair);

    Integer removeSubject(DataKeyPair dataKeyPair);

}
