package com.lazy.demo.sshvue.server.api.dao;

import com.lazy.demo.sshvue.server.api.entity.TUniqueEntity;
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
public interface IUniqueRepository extends JpaRepository<TUniqueEntity, Long> {


    TUniqueEntity findByType(String type);

}
