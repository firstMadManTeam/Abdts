package com.abdts.service.mysql;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.score.Score;

import java.util.List;

/**
 * @author pzy
 */
public interface TableService {

    Integer createTable(DataKeyPair dataKeyPair);

    Integer addTableInfo(List<Score> dataKeyPairs);

}
