package com.abdts.dao.sign;

import com.abdts.common.util.DataKeyPair;
import com.abdts.vo.sign.SignVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignDao {

    List<SignVO> getSignlist(DataKeyPair dataKeyPair);

    Integer pageSign(DataKeyPair dataKeyPair);

    Integer insSign(DataKeyPair dataKeyPair);

    Integer updSign(DataKeyPair dataKeyPair);

    Integer getSignsCount();

}
