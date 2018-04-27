package com.abdts.common.util;

/**
 * @author pzy
 */
public class StuChoose {

    /**
     * 判断是男还是女
     * @param sexId 男女Id
     * @return
     */
    public static String getSex(Integer sexId){
        if (sexId == 1){
            return  "男";
        }
        return  "女";
    }

    /**
     * 判读学生 学校状态
     * @param state 状态id
     * @return
     */
    public static String getState(Integer state){
        if (state == 1){
            return "在读";
        }
        return "劝退";
    }

}
