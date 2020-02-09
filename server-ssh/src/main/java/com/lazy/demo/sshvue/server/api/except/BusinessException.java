package com.lazy.demo.sshvue.server.api.except;

import com.lazy.demo.sshvue.server.api.enums.ResponseEnum;

/**
 * <p>
 * 业务异常类
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/8.
 */
public class BusinessException extends RuntimeException {


    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public BusinessException setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BusinessException setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public BusinessException() {
    }

    public BusinessException(ResponseEnum resp) {
        super(resp.getDesc());
        this.code = resp.getCode();
        this.msg = resp.getDesc();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
