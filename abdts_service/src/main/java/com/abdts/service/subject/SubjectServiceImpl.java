package com.abdts.service.subject;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.subject.SubjectDao;
import com.abdts.entity.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> getSubjectList(DataKeyPair dataKeyPair) {
        return subjectDao.getSubjectList(dataKeyPair);
    }

    @Override
    public Integer addSubject(DataKeyPair dataKeyPair) {
        return subjectDao.addSubject(dataKeyPair);
    }

    @Override
    public Integer removeSubject(DataKeyPair dataKeyPair) {
        return subjectDao.removeSubject(dataKeyPair);
    }
}
