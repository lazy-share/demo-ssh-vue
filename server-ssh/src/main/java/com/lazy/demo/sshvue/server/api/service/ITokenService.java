package com.lazy.demo.sshvue.server.api.service;

import com.lazy.demo.sshvue.server.api.entity.TTokenEntity;

import java.time.LocalDateTime;

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

    TTokenEntity saveOrUpdate(TTokenEntity entity);

    void deleteById(Long id);

    void deleteByExpireToken();
}
