package com.lazy.demo.sshvue.server.api.service.impl;

import com.lazy.demo.sshvue.server.api.dao.ITokenRepository;
import com.lazy.demo.sshvue.server.api.entity.TTokenEntity;
import com.lazy.demo.sshvue.server.api.service.ITokenService;
import com.lazy.demo.sshvue.server.api.token.TokenHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

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
public class TokenServiceImpl implements ITokenService {

    private Logger log = LoggerFactory.getLogger(TokenServiceImpl.class);

    @Autowired
    private ITokenRepository iTokenRepository;

    @Override
    public TTokenEntity findByToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        return iTokenRepository.findByToken(token);
    }

    @Override
    public TTokenEntity saveOrUpdate(TTokenEntity entity) {
        return iTokenRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        iTokenRepository.deleteById(id);
    }

    @Override
    public void deleteByExpireToken() {

        LocalDateTime endTime = LocalDateTime.now().minusSeconds(TokenHolder.getSingle().getExpireSecond());
        log.info("开始清理截止 [" + endTime.toString() + "] 过期的token");
        iTokenRepository.deleteExpireToken(endTime);
    }
}
