package com.lazy.demo.sshvue.server.api.token;

import com.lazy.demo.sshvue.server.api.entity.TAccountEntity;
import com.lazy.demo.sshvue.server.api.entity.TTokenEntity;
import com.lazy.demo.sshvue.server.api.service.IAccountService;
import com.lazy.demo.sshvue.server.api.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * <p>
 * token holder
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/8.
 */
@Configuration
@ConfigurationProperties(prefix = "token")
public class TokenHolder {


    private static TokenHolder tokenHolder;

    private static final ThreadLocal<TokenAttr> TOKEN_HOLDER = new ThreadLocal<>();

    @Autowired
    private ITokenService iTokenService;
    @Autowired
    private IAccountService iAccountService;

    private long expireSecond;

    public void set(TokenAttr attr) {
        TOKEN_HOLDER.set(attr);
    }

    public void cleanup() {
        TOKEN_HOLDER.remove();
    }

    @PostConstruct
    public void init() {
        tokenHolder = this;
    }

    public static TokenHolder getSingle() {
        return tokenHolder;
    }

    public TokenAttr get() {
        return TOKEN_HOLDER.get();
    }

    public boolean isValidAndSet(String token) {

        TTokenEntity tokenEntity = iTokenService.findByToken(token);

        return this.isValidAndSet(tokenEntity);
    }

    public boolean isValidAndSet(TTokenEntity tokenEntity) {

        if (tokenEntity == null) {
            return false;
        }

        boolean isValid = LocalDateTime.now().isBefore(tokenEntity.getLastUpdateTime().plusSeconds(this.getExpireSecond()));

        if (!isValid) {
            //token过期，删除token
            iTokenService.deleteById(tokenEntity.getId());
            return false;
        }

        //更新token有效时间
        TokenHolder.getSingle().updateTokenExpire(tokenEntity);

        //保存token信息
        TAccountEntity accountEntity = iAccountService.findById(tokenEntity.getAccountId());
        this.set(
                new TokenAttr()
                        .setAccountId(tokenEntity.getAccountId())
                        .setEmail(accountEntity.getEmail())
                        .setPassword(accountEntity.getPassword())
                        .setUsername(accountEntity.getUsername())
                        .setSalt(accountEntity.getSalt())
        );
        return true;
    }

    public void updateTokenExpire(TTokenEntity tokenEntity) {
        tokenEntity.setLastUpdateTime(LocalDateTime.now());
        iTokenService.saveOrUpdate(tokenEntity);
    }

    public long getExpireSecond() {
        return expireSecond;
    }

    public TokenHolder setExpireSecond(long expireSecond) {
        this.expireSecond = expireSecond;
        return this;
    }
}
