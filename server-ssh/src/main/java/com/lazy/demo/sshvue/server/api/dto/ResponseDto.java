package com.lazy.demo.sshvue.server.api.dto;

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

    public ResponseDto(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseDto success(Object data){
        return new ResponseDto()
                .setCode("200").setMsg("success").setData(data);
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
