package com.lazy.demo.sshvue.server.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lazy.demo.sshvue.server.api.dto.PageDto;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <p>
 * example实体
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Entity
@Table(name = "t_example")
public class TExampleEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "valid_status")
    private String validStatus;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdateTime;

    @Transient
    private LocalDateTime lastUpdateTime2;

    @Transient
    private PageDto paging;

    public PageDto getPaging() {
        return paging;
    }

    public TExampleEntity setPaging(PageDto paging) {
        this.paging = paging;
        return this;
    }

    public LocalDateTime getLastUpdateTime2() {
        return lastUpdateTime2;
    }

    public TExampleEntity setLastUpdateTime2(LocalDateTime lastUpdateTime2) {
        this.lastUpdateTime2 = lastUpdateTime2;
        return this;
    }

    public Long getId() {
        return id;
    }

    public TExampleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public TExampleEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public TExampleEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TExampleEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public TExampleEntity setValidStatus(String validStatus) {
        this.validStatus = validStatus;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public TExampleEntity setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public TExampleEntity setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }
}
