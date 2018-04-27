package com.abdts.dao.notice;

import com.abdts.common.util.DataKeyPair;
import com.abdts.vo.notice.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pzy
 */
@Mapper
public interface NoticeDao {

    List<NoticeVO> getNotices(DataKeyPair dataKeyPair);

    Integer pageNotice(DataKeyPair dataKeyPair);

    Integer getNoticesCount();

}
