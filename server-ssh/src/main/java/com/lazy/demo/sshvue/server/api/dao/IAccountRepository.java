package com.lazy.demo.sshvue.server.api.dao;

import com.lazy.demo.sshvue.server.api.entity.TAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 账号领域DAO
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Repository
public interface IAccountRepository extends JpaRepository<TAccountEntity, Long> {

    TAccountEntity findByUsername(String username);

}
