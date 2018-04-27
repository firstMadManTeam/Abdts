package com.abdts.service.notice;

import com.abdts.common.util.DataKeyPair;
import com.abdts.vo.notice.NoticeVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author pzy
 */
@Component
public interface NoticeService {

    List<NoticeVO> getNotices(DataKeyPair dataKeyPair);

    Integer pageNotice(DataKeyPair dataKeyPair);

    Integer getNoticesCount();

}
