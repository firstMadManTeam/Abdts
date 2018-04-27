package com.abdts.service.notice;

import com.abdts.common.util.DataKeyPair;
import com.abdts.dao.notice.NoticeDao;
import com.abdts.vo.notice.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzy
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<NoticeVO> getNotices(DataKeyPair dataKeyPair) {
        return noticeDao.getNotices(dataKeyPair);
    }

    @Override
    public Integer pageNotice(DataKeyPair dataKeyPair) {
        return noticeDao.pageNotice(dataKeyPair);
    }

    @Override
    public Integer getNoticesCount() {
        return noticeDao.getNoticesCount();
    }

}
