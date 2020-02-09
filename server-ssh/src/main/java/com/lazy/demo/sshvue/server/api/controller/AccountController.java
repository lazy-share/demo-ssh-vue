package com.lazy.demo.sshvue.server.api.controller;

import com.lazy.demo.sshvue.server.api.constants.Constant;
import com.lazy.demo.sshvue.server.api.dto.ResponseDto;
import com.lazy.demo.sshvue.server.api.entity.TAccountEntity;
import com.lazy.demo.sshvue.server.api.entity.TTokenEntity;
import com.lazy.demo.sshvue.server.api.enums.ResponseEnum;
import com.lazy.demo.sshvue.server.api.except.BusinessException;
import com.lazy.demo.sshvue.server.api.service.IAccountService;
import com.lazy.demo.sshvue.server.api.service.ITokenService;
import com.lazy.demo.sshvue.server.api.service.IUniqueService;
import com.lazy.demo.sshvue.server.api.token.TokenAttr;
import com.lazy.demo.sshvue.server.api.token.TokenHolder;
import com.lazy.demo.sshvue.server.api.utils.AssertUtils;
import com.lazy.demo.sshvue.server.api.utils.MD5Utils;
import com.lazy.demo.sshvue.server.api.utils.UuidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SignatureException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 账号控制器
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@RestController
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private ITokenService iTokenService;

    @Autowired
    private IUniqueService iUniqueService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @DeleteMapping("/sessions/{token}")
    public ResponseDto deleteSession(@PathVariable("token") String token) {
        if (AssertUtils.isEmpty(token)) {
            return ResponseDto.paramError("token is empty");
        }
        TTokenEntity dbEntity = iTokenService.findByToken(token);
        if (dbEntity == null) {
            return ResponseDto.success(null);
        }
        iTokenService.deleteById(dbEntity.getId());

        return ResponseDto.success(null);
    }


    @PutMapping("/sessions")
    public ResponseDto putSession(@RequestBody TAccountEntity paramBody) {

        String username = paramBody.getUsername();
        String password = paramBody.getPassword();

        AssertUtils.assertIsEmpty(username);
        AssertUtils.assertIsEmpty(password);

        TAccountEntity accountEntity = iAccountService.findByUsername(username);

        if (accountEntity == null) {
            throw new BusinessException(ResponseEnum.ACCOUNT_ERROR);
        }

        try {
            password = MD5Utils.md5Signature(password, accountEntity.getSalt());
        } catch (SignatureException e) {
            logger.error("", e);
            throw new BusinessException(ResponseEnum.SYSTEM_ERROR);
        }

        if (!password.equals(accountEntity.getPassword())) {
            throw new BusinessException(ResponseEnum.PASSWORD_ERROR);
        }

        //创建token
        String token = UuidUtils.getUuid();
        TTokenEntity dbToken = new TTokenEntity()
                .setId(iUniqueService.getPrimaryKey())
                .setAccountId(accountEntity.getId())
                .setValidStatus(Constant.Y)
                .setCreateTime(LocalDateTime.now());
        dbToken.setToken(token)
                .setLastUpdateTime(LocalDateTime.now());
        iTokenService.saveOrUpdate(dbToken);

        TokenHolder.getSingle().set(new TokenAttr()
                .setSalt(accountEntity.getSalt())
                .setUsername(username).
                        setPassword(password).setEmail(accountEntity.getEmail())
                .setAccountId(accountEntity.getId()));

        Map<String, Object> resp = new HashMap<>(2);
        resp.put("token", token);
        resp.put("account", TokenHolder.getSingle().get());

        return ResponseDto.success(resp);
    }


}
