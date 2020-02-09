package com.lazy.demo.sshvue.server.api.service;

import com.lazy.demo.sshvue.server.api.entity.TTokenEntity;

/**
 * <p>
 * 登录token服务接口
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
public interface ITokenService {



    TTokenEntity findByToken(String token);

    TTokenEntity findByAccountId(Long accountId);

    TTokenEntity saveOrUpdate(TTokenEntity entity);


}
