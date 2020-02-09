package com.lazy.demo.sshvue.server.api.dto;

import com.lazy.demo.sshvue.server.api.enums.ResponseEnum;

import java.io.Serializable;

/**
 * <p>
 * 响应DTO
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
public class ResponseDto implements Serializable {

    private static final long serialVersionUID = 987689L;

    private String code;
    private String msg;
    private Object data;

    public ResponseDto() {
    }

    public ResponseDto(ResponseEnum resp) {
        this.code = resp.getCode();
        this.msg = resp.getDesc();
    }

    public ResponseDto(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static ResponseDto success(Object data) {
        return new ResponseDto(ResponseEnum.SUCCESS).setData(data);
    }

    public static ResponseDto paramError(String msg) {
        return new ResponseDto(ResponseEnum.PARAM_ERROR).setMsg(msg);
    }

    public static ResponseDto except() {
        return new ResponseDto(ResponseEnum.SYSTEM_ERROR);
    }


    public String getCode() {
        return code;
    }

    public ResponseDto setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseDto setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseDto setData(Object data) {
        this.data = data;
        return this;
    }
}
