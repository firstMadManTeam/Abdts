package com.abdts.search.sign;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.service.notice.NoticeService;
import com.abdts.service.sign.SignService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author pzy
 */
@RestController
@RequestMapping("/signCon")
public class SignSearch extends BaseController {

    @Resource
    private SignService signService;
    @Resource
    private NoticeService noticeService;

    private Logger logger = Logger.getLogger(SignService.class);

    @RequestMapping(value = "/getsignlist", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public Object getSignlist() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        if (dataKeyPair.containsKey("signId")) {
            if (dataKeyPair.getInt("signId") == 0) {
                return noticeService.getNotices(dataKeyPair);
            } else {
                return signService.getSignlist(dataKeyPair);
            }
        }
        return null;
    }

    @RequestMapping(value = "/pageSignlist", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public Object pageSignlist() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        if (dataKeyPair.containsKey("signId")) {
            if (dataKeyPair.getInt("signId") == 0) {
                return noticeService.pageNotice(dataKeyPair);
            } else {
                return signService.pageSign(dataKeyPair);
            }
        }
        return 1;
    }

    @RequestMapping(value = "/getSignCount", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public Integer getSignCount() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        if (dataKeyPair.containsKey("signId")) {
            if (dataKeyPair.getInt("signId") == 0) {
                return noticeService.getNoticesCount();
            } else {
                return signService.getSignsCount();
            }
        }
        return 0;
    }


}
