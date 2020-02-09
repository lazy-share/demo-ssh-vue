package com.lazy.demo.sshvue.server.api.service.impl;

import com.lazy.demo.sshvue.server.api.dao.IAccountRepository;
import com.lazy.demo.sshvue.server.api.entity.TAccountEntity;
import com.lazy.demo.sshvue.server.api.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 账号服务实现类
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public TAccountEntity findById(Long id) {
        return iAccountRepository.findById(id).orElse(null);
    }

    @Override
    public TAccountEntity findByUsername(String username) {
        return iAccountRepository.findByUsername(username);
    }

    @Override
    public void saveOrUpdate(TAccountEntity entity) {
        iAccountRepository.save(entity);
    }
}
