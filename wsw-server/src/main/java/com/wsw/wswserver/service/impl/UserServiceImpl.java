package com.wsw.wswserver.service.impl;

import com.wsw.dao.mapper.UserMapper;
import com.wsw.module.entity.User;
import com.wsw.wswserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author WangSongWen
 * @Date: Created in 13:22 2020/9/8
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (null == user){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        return user;
    }
}
