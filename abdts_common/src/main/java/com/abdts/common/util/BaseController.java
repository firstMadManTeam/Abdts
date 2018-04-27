package com.abdts.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;


/**
 * 基础路由
 * @author zy
 * @version 0.0.1
 */
public class BaseController {

    private Logger log = LoggerFactory.getLogger(BaseController.class);

    private static final long serialVersionUID = 6357869213649815390L;

    public DataKeyPair getDataKeyPair() {
        return new DataKeyPair(this.getRequest());
    }

    public HttpServletRequest getRequest() {
        HttpServletRequest request =
                ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /** 生成用户唯一标识 */
    public String get32UUID () {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        System.out.println(sdf.parse("2018/3/14 12:00").getTime() / 1000);
    }



}
