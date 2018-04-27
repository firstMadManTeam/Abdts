package com.abdts.service.score;

import com.abdts.common.util.DataKeyPair;
import com.abdts.vo.score.ScoreVO;

import java.util.List;

/**
 * @author pzy
 */
public interface ScoreService {

    List<ScoreVO> getScores(DataKeyPair dataKeyPair);

    Integer getScoreSum(DataKeyPair dataKeyPair);

    Integer getScoreCount(DataKeyPair dataKeyPair);

}
