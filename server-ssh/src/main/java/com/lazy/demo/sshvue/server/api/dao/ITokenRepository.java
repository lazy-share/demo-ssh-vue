package com.lazy.demo.sshvue.server.api.dao;

import com.lazy.demo.sshvue.server.api.entity.TTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

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

    //update和delete需要Modifying注解，查询的话不需要Modifying注解
    @Modifying
    @Query("delete from TTokenEntity t where t.lastUpdateTime <= ?1")
    void deleteExpireToken(LocalDateTime endTime);

}
