package com.lazy.demo.sshvue.server.api.dao;

import com.lazy.demo.sshvue.server.api.entity.TExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * example领域DAO
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Repository
public interface IExampleRepository extends JpaRepository<TExampleEntity, Long>, JpaSpecificationExecutor<TExampleEntity> {

}
