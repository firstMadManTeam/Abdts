package com.abdts.search.homework;

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
public class HomeWorkSearch extends BaseController {

    @Resource
    private HomeWorkService homeWorkService;

    private Logger logger = Logger.getLogger(SignService.class);

    @RequestMapping(value = "/getHomeWorkList", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public Object getHomeWorkList() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        return homeWorkService.getHomeWorks(dataKeyPair);
    }

}
