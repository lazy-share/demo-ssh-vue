package com.lazy.demo.sshvue.server.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * <p>
 * 登录token实体
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Entity
@Table(name = "t_token")
public class TTokenEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "valid_status")
    private String validStatus;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    public Long getId() {
        return id;
    }

    public TTokenEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getToken() {
        return token;
    }

    public TTokenEntity setToken(String token) {
        this.token = token;
        return this;
    }

    public Long getAccountId() {
        return accountId;
    }

    public TTokenEntity setAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public TTokenEntity setValidStatus(String validStatus) {
        this.validStatus = validStatus;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public TTokenEntity setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public TTokenEntity setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }
}
