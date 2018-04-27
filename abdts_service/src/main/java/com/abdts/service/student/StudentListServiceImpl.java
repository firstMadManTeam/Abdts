package com.abdts.service.student;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.student.StudentListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pzy
 */
@Service
public class StudentListServiceImpl implements StudentListService {

    @Autowired
    private StudentListDao studentListDao;

    @Override
    public boolean delStuList(DataKeyPair dkp) throws Exception {
        if (studentListDao.delStuList(dkp) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addStuList(DataKeyPair dkp) throws Exception {
        if (studentListDao.addStuList(dkp) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updStuList(DataKeyPair dkp) throws Exception {
        if (studentListDao.updStuList(dkp) > 0) {
            return true;
        }
        return false;
    }

}
