package com.abdts.dao.mysql;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.score.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pzy
 */
@Mapper
public interface TableDao {

    Integer createTable(DataKeyPair dataKeyPair);

    Integer addTableInfo(List<Score> dataKeyPairs);

}
