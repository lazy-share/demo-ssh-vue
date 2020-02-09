package com.lazy.demo.sshvue.server.api.service;

import com.lazy.demo.sshvue.server.api.entity.TAccountEntity;

/**
 * <p>
 * 账号服务接口
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
public interface IAccountService {


    TAccountEntity findById(Long id);


    TAccountEntity findByUsername(String username);

    void saveOrUpdate(TAccountEntity entity);

}
