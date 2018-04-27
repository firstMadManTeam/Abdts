package com.abdts.dao.score;

import com.abdts.common.util.DataKeyPair;
import com.abdts.vo.score.ScoreVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pzy
 */
@Mapper
public interface ScoreDao {

    List<ScoreVO> getScores(DataKeyPair dataKeyPair);

    Integer getScoreSum(DataKeyPair dataKeyPair);

    Integer getScoreCount(DataKeyPair dataKeyPair);

}
