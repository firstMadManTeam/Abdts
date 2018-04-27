package com.abdts.service.identity;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.identity.StudentIdentityDao;
import com.abdts.entity.identity.StudentIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class StudentIdentityServiceImpl implements StudentIdentityService {

    @Autowired
    StudentIdentityDao studentIdentityDao;

    @Override
    public List<StudentIdentity> getStuIdentity(DataKeyPair dataKeyPair) {
        return studentIdentityDao.getStuIdentity(dataKeyPair);
    }
}
