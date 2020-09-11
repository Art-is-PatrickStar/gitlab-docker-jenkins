package com.wsw.wswserver.service.impl;

import com.wsw.wswserver.entity.Permission;
import com.wsw.wswserver.mapper.PermissionMapper;
import com.wsw.wswserver.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author WangSongWen
 * @Date: Created in 13:49 2020/9/10
 * @Description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByUserId(Integer userId) {
        List<Permission> permissionList = permissionMapper.findByUserId(userId);
        return permissionList;
    }
}
