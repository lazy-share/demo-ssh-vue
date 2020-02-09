package com.lazy.demo.sshvue.server.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lazy.demo.sshvue.server.api.enums.ResponseEnum;
import org.slf4j.MDC;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/9.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebResultDto<V> implements Serializable {
    private static final long serialVersionUID = -4657573158L;
    private String code;
    private String msg;

    private V data;
    private Long count;
    private Integer totalPage;
    private Integer pageSize;
    private Integer currentPage;
    private String traceId;

    public WebResultDto() {
        this(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    public WebResultDto(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.traceId = MDC.get("apmTraceId");
    }

    public WebResultDto(ResponseEnum codeEnum, V data) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getDesc();
        this.data = data;
        this.traceId = MDC.get("apmTraceId");
    }

    public WebResultDto(ResponseEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getDesc();
        this.traceId = MDC.get("apmTraceId");
    }

    public WebResultDto(V data) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getDesc();
        this.data = data;
        this.traceId = MDC.get("apmTraceId");
    }

    public WebResultDto(String code, String msg, V data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.traceId = MDC.get("apmTraceId");
    }

    public static WebResultDto success() {
        return new WebResultDto(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    public static WebResultDto success(Object data) {
        return new WebResultDto(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), data);
    }

    public static WebResultDto error(String msg) {
        return new WebResultDto(ResponseEnum.SYSTEM_ERROR.getCode(), msg);
    }

    public static WebResultDto exception() {
        return new WebResultDto(ResponseEnum.SYSTEM_ERROR.getCode(), ResponseEnum.SYSTEM_ERROR.getDesc());
    }

    public String getCode() {
        return this.code;
    }

    public WebResultDto setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public WebResultDto setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public V getData() {
        return this.data;
    }

    public WebResultDto setData(V data) {
        this.data = data;
        return this;
    }

    public Long getCount() {
        return this.count;
    }

    public WebResultDto setCount(Long count) {
        this.count = count;
        return this;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public WebResultDto setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public WebResultDto setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public WebResultDto setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public WebResultDto<V> setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }
}

