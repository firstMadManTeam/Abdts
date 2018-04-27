package com.abdts.common.util;

import java.io.Serializable;

/**
 * JSON结果封装
 * @author zy
 */
public class SuccessOrFailure implements Serializable {

    /** 是否成功 */
    private boolean success;

    /** 消息 */
    private Object message;

    public SuccessOrFailure() {}

    public SuccessOrFailure(boolean success, Object message) {
        this.success = success;
        this.message = message;
    }

    /** 无消息的 success */
    public static SuccessOrFailure SUCCESS = new SuccessOrFailure(true,null);

    /** 成功（有消息） */
    public static SuccessOrFailure SUCCESS(Object message) {
        return new SuccessOrFailure(true,message);
    }

    /** 失败 */
    public static SuccessOrFailure FAILURE(Object message) {
        return new SuccessOrFailure(false,message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SuccessOrFailure [success=" + success + ", message=" + message + "]";
    }

}
