package com.lazy.demo.sshvue.server.api.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/8.
 */
public enum UniqueTypeEnum {

    PRIMARY_KEY("PRIMARY_KEY", "主键");

    private String code;
    private String desc;

    UniqueTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public UniqueTypeEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public UniqueTypeEnum setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
