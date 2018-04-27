package com.abdts.service.homework;

import com.abdts.common.util.DataKeyPair;
import com.abdts.vo.homework.HomeWorkVO;

import java.util.List;

/**
 * @author pzy
 */
public interface HomeWorkService {

    List<HomeWorkVO> getHomeWorks(DataKeyPair dataKeyPair);

    Integer addHomeWork(DataKeyPair dataKeyPair);

    Integer updHomeWork(DataKeyPair dataKeyPair);

}
