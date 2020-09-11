package com.wsw.wswserver.service;

import com.wsw.wswserver.entity.MyUser;
import com.wsw.wswserver.entity.Permission;
import com.wsw.wswserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangSongWen
 * @Date: Created in 10:51 2020/9/10
 * @Description:
 */
//@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        if (null == user){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<Permission> permissionList = permissionService.findByUserId(user.getId());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(permissionList)){
            for (Permission permission : permissionList) {
                authorityList.add(new SimpleGrantedAuthority(permission.getCode()));
            }
        }

        MyUser myUser = new MyUser(user.getUsername(), passwordEncoder.encode(user.getPassword()), authorityList);
        return myUser;
    }
}
