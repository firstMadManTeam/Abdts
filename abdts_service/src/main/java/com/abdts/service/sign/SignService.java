package com.abdts.service.sign;

import com.abdts.common.util.DataKeyPair;
import com.abdts.vo.sign.SignVO;

import java.util.List;

public interface SignService {

    List<SignVO> getSignlist(DataKeyPair dataKeyPair);

    Integer pageSign(DataKeyPair dataKeyPair);

    Integer insSign(DataKeyPair dataKeyPair);

    Integer updSign(DataKeyPair dataKeyPair);

    Integer getSignsCount();


}
