package com.wsw.wswserver.service.impl;


import com.wsw.wswserver.entity.User;
import com.wsw.wswserver.mapper.UserMapper;
import com.wsw.wswserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author WangSongWen
 * @Date: Created in 13:22 2020/9/8
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }
}
