package com.lazy.demo.sshvue.server.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * 账号实体
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Entity
@Table(name = "t_account")
public class TAccountEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "valid_status")
    private String validStatus;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    public Long getId() {
        return id;
    }

    public TAccountEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TAccountEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TAccountEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public TAccountEntity setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TAccountEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public TAccountEntity setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public TAccountEntity setValidStatus(String validStatus) {
        this.validStatus = validStatus;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public TAccountEntity setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public TAccountEntity setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }
}
