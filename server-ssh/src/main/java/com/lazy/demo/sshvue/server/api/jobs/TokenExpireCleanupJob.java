package com.lazy.demo.sshvue.server.api.jobs;

import com.lazy.demo.sshvue.server.api.service.ITokenService;
import com.lazy.demo.sshvue.server.api.token.TokenHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * <p>
 * token 过期清除job
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/9.
 */
@Configuration
@EnableScheduling
public class TokenExpireCleanupJob {

    @Autowired
    private ITokenService iTokenService;

    //每天23：59分定时进行清理
//    @Scheduled(cron = "0 59 23 * * ?")
    //测试用
    @Scheduled(cron = "* 0/10 * * * ?")
    public void configureTasks1() {
        iTokenService.deleteByExpireToken();
    }

}
