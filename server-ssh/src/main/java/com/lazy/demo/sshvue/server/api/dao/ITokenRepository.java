package com.lazy.demo.sshvue.server.api.dao;

import com.lazy.demo.sshvue.server.api.entity.TTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 登录token领域DAO
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Repository
public interface ITokenRepository extends JpaRepository<TTokenEntity, Long> {


    TTokenEntity findByToken(String token);

    TTokenEntity findByAccountId(Long accountId);

}
