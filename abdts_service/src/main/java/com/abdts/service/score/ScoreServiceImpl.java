package com.abdts.service.score;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.score.ScoreDao;
import com.abdts.vo.score.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public List<ScoreVO> getScores(DataKeyPair dataKeyPair) {
        return scoreDao.getScores(dataKeyPair);
    }

    @Override
    public Integer getScoreSum(DataKeyPair dataKeyPair) {
        return scoreDao.getScoreSum(dataKeyPair);
    }

    @Override
    public Integer getScoreCount(DataKeyPair dataKeyPair) {
        return scoreDao.getScoreCount(dataKeyPair);
    }
}
