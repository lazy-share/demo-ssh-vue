package com.lazy.demo.sshvue.server.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 账号实体
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Entity
@Table(name = "t_unique")
public class TUniqueEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "val")
    private Long val;

    @Column(name = "type")
    private String type;

    public Long getVal() {
        return val;
    }

    public TUniqueEntity setVal(Long val) {
        this.val = val;
        return this;
    }

    public String getType() {
        return type;
    }

    public TUniqueEntity setType(String type) {
        this.type = type;
        return this;
    }

    public Long getId() {
        return id;
    }

    public TUniqueEntity setId(Long id) {
        this.id = id;
        return this;
    }


}
