package com.lazy.demo.sshvue.server.api.controller;

import com.lazy.demo.sshvue.server.api.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 首页
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@RestController
public class HomeController {


    @GetMapping("/index")
    public ResponseDto home() {
        return ResponseDto.success("this is home page");
    }
}
