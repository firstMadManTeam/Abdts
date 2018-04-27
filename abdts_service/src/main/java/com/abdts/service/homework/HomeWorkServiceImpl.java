package com.abdts.service.homework;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.homework.HomeWorkDao;
import com.abdts.vo.homework.HomeWorkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class HomeWorkServiceImpl implements HomeWorkService {

    @Autowired
    private HomeWorkDao homeWorkDao;

    @Override
    public List<HomeWorkVO> getHomeWorks(DataKeyPair dataKeyPair) {
        return homeWorkDao.getHomeWorks(dataKeyPair);
    }

    @Override
    public Integer addHomeWork(DataKeyPair dataKeyPair) {
        return homeWorkDao.addHomeWork(dataKeyPair);
    }

    @Override
    public Integer updHomeWork(DataKeyPair dataKeyPair) {
        return homeWorkDao.updHomeWork(dataKeyPair);
    }
}
