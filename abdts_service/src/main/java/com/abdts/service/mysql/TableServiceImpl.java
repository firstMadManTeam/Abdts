package com.abdts.service.mysql;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.mysql.TableDao;
import com.abdts.entity.score.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDao tableDao;

    @Override
    public Integer createTable(DataKeyPair dataKeyPair) {
        return tableDao.createTable(dataKeyPair);
    }

    @Override
    public Integer addTableInfo(List<Score> dataKeyPairs) {
        return tableDao.addTableInfo(dataKeyPairs);
    }

}
