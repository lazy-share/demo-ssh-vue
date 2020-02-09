package com.lazy.demo.sshvue.server.api.enums;

/**
 * <p>
 * 响应枚举
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/8.
 */
public enum ResponseEnum {

    SUCCESS("200", "请求处理成功"),
    TOKEN_ERROR("301", "token请求头为空"),
    TOKEN_EXPIRE("302", "token过期了"),
    PARAM_ERROR("400", "请求参数错误"),
    ACCOUNT_ERROR("401", "登录账号错误"),
    PASSWORD_ERROR("401", "密码错误"),
    SYSTEM_ERROR("500", "服务器错误"),;

    private String code;
    private String desc;

    ResponseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public ResponseEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public ResponseEnum setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
