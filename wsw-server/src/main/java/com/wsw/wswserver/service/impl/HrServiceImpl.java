package com.wsw.wswserver.service.impl;

import com.wsw.wswserver.entity.Hr;
import com.wsw.wswserver.repository.HrRepository;
import com.wsw.wswserver.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author WangSongWen
 * @Date: Created in 10:31 2020/9/11
 * @Description:
 */
@Service
public class HrServiceImpl implements HrService {
    @Autowired
    private HrRepository hrRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrRepository.findHrByUsername(username);
        if (null == hr){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        return hr;
    }
}
