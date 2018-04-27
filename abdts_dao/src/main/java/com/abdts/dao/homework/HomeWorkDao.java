package com.abdts.dao.homework;

import com.abdts.common.util.DataKeyPair;
import com.abdts.vo.homework.HomeWorkVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pzy
 */
@Mapper
public interface HomeWorkDao {

    List<HomeWorkVO> getHomeWorks(DataKeyPair dataKeyPair);

    Integer addHomeWork(DataKeyPair dataKeyPair);

    Integer updHomeWork(DataKeyPair dataKeyPair);

}
