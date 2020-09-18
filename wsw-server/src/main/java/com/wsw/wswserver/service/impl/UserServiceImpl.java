package com.wsw.wswserver.service.impl;

import com.wsw.wswserver.entity.User;
import com.wsw.wswserver.repository.UserRepository;
import com.wsw.wswserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author WangSongWen
 * @Date: Created in 10:31 2020/9/11
 * @Description:
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository hrRepository;

    @Override
    @Cacheable(key = "#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = hrRepository.findHrByUsername(username);
        if (null == user){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        return user;
    }
}
