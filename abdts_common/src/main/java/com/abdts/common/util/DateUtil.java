package com.abdts.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期辅助类
 * @author zy
 */
public class DateUtil {

    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat sdfMiss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * str2date 支持 yyyyMMdd HH:mm:ss | yyyyMMdd
     * @param str String 类型 日期
     * @return Date 类型日期
     * @throws ParseException
     */
    public static Date parse(final String str)  {
        Date date = null;
        try {
            date = str.contains(":") ? sdfMiss.parse(str) : sdf.parse(str);
        } catch (ParseException e) {
            log.info(e.getMessage());
        }
        return date;
    }

    /**
     * date2str yyyyMMdd
     * @param date Date类型日期
     * @return yyyy-MM-dd
     */
    public static String formatYMD(final Date date) {
        return sdf.format(date);
    }

    /**
     * date2str yyyyMMdd HH:mm:ss
     * @param date Date类型日期
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String formatYMDHMS(final Date date) {
        return sdfMiss.format(date);
    }

}
