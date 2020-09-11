package com.wsw.wswserver.service;

import com.wsw.wswserver.entity.User;

/**
 * @Author WangSongWen
 * @Date: Created in 9:57 2020/9/2
 * @Description:
 */
public interface UserService{
    User getUserByUserName(String username);
}
