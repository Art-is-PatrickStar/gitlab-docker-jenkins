package com.wsw.wswclient1.controller;

import com.wsw.wswclient1.entity.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangSongWen
 * @Date: Created in 13:25 2020/9/10
 * @Description:
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public ResponseBean login(){
        return ResponseBean.error("尚未登录，请登录！");
    }
}
