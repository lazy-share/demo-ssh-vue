package com.lazy.demo.sshvue.server.api.dto;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/9.
 */
public class ExampleQueryDto implements Serializable {

    private static final long serialVersionUID = -98456537689L;

    private Long id;

    private Integer age;

    private String name;

    private String email;

    private String validStatus;

    private String createTime;

    private String lastUpdateTime;

    private String lastUpdateTime2;

    private PageDto paging;

    public PageDto getPaging() {
        return paging;
    }

    public ExampleQueryDto setPaging(PageDto paging) {
        this.paging = paging;
        return this;
    }

    public String getLastUpdateTime2() {
        return lastUpdateTime2;
    }

    public ExampleQueryDto setLastUpdateTime2(String lastUpdateTime2) {
        this.lastUpdateTime2 = lastUpdateTime2;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ExampleQueryDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public ExampleQueryDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExampleQueryDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ExampleQueryDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public ExampleQueryDto setValidStatus(String validStatus) {
        this.validStatus = validStatus;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public ExampleQueryDto setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public ExampleQueryDto setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

}
