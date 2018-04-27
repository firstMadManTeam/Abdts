package com.abdts.controller.homework;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.service.homework.HomeWorkService;
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
@RequestMapping("/homework")
public class HomeWorkController extends BaseController {

    @Resource
    private HomeWorkService homeWorkService;

    private Logger logger = Logger.getLogger(SignService.class);

    @RequestMapping(value = "/addHomeWork", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public Object addHomeWork() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        if (homeWorkService.addHomeWork(dataKeyPair) > 0) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", true);
            dataKeyPair.put("smg", "新增作业成功~");
        } else {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("smg", "抱歉，添加作业失败~");
        }
        return dataKeyPair;
    }

}
