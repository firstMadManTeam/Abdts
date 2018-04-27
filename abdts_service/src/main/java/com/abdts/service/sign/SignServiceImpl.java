package com.abdts.service.sign;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.sign.SignDao;
import com.abdts.vo.sign.SignVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SignDao signDao;

    @Override
    public List<SignVO> getSignlist(DataKeyPair dataKeyPair) {
       return signDao.getSignlist(dataKeyPair);
    }

    @Override
    public Integer pageSign(DataKeyPair dataKeyPair) {
        return signDao.pageSign(dataKeyPair);
    }

    @Override
    public Integer insSign(DataKeyPair dataKeyPair) {
        return signDao.insSign(dataKeyPair);
    }

    @Override
    public Integer updSign(DataKeyPair dataKeyPair) {
        return signDao.updSign(dataKeyPair);
    }

    @Override
    public Integer getSignsCount() {
        return signDao.getSignsCount();
    }
}
