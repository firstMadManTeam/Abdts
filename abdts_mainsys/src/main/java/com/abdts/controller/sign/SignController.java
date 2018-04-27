package com.abdts.controller.sign;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.service.sign.SignService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * @author pzy
 */
@Controller
@RequestMapping("/signCon")
public class SignController extends BaseController {

    @Resource
    private SignService signService;

    private Logger logger = Logger.getLogger(SignService.class);

    @RequestMapping(value = "/inssign", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Integer insSign() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        return signService.insSign(dataKeyPair);
    }

    @RequestMapping(value = "/updSign", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public DataKeyPair updSign() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        if (signService.updSign(dataKeyPair) > 0) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", true);
            dataKeyPair.put("smg", "回复成功~");
        } else {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("smg", "回复失败~");
        }
        return dataKeyPair;
    }
}
