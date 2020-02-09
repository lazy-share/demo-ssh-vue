package com.lazy.demo.sshvue.server.api;

import com.lazy.demo.sshvue.server.api.constants.Constant;
import com.lazy.demo.sshvue.server.api.entity.TAccountEntity;
import com.lazy.demo.sshvue.server.api.service.IAccountService;
import com.lazy.demo.sshvue.server.api.service.IUniqueService;
import com.lazy.demo.sshvue.server.api.utils.MD5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SignatureException;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
class DemoSshVueApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IUniqueService iUniqueService;

    @Test
    public void initTestData() throws SignatureException {
        iAccountService.saveOrUpdate(
                new TAccountEntity()
                        .setEmail("13666666666@163.com")
                        .setMobile("13666666666")
                        .setLastUpdateTime(LocalDateTime.now())
                        .setCreateTime(LocalDateTime.now())
                        .setSalt("abcd")
                        .setPassword(MD5Utils.md5Signature("123456", "abcd"))
                        .setUsername("lazy")
                        .setValidStatus(Constant.Y)
                        .setId(iUniqueService.getPrimaryKey()));
    }

}
