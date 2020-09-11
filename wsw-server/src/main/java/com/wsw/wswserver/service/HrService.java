package com.wsw.wswserver.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author WangSongWen
 * @Date: Created in 10:29 2020/9/11
 * @Description:
 */
public interface HrService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
