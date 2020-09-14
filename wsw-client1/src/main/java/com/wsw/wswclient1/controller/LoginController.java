package com.wsw.wswserver.controller;

import com.wsw.wswserver.entity.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangSongWen
 * @Date: Created in 10:59 2020/9/14
 * @Description:
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public ResponseBean login(){
        return ResponseBean.error("尚未登录，请登录！");
    }
}
