package com.wsw.wswserver.service;

import com.wsw.wswserver.entity.Permission;

import java.util.List;

/**
 * @Author WangSongWen
 * @Date: Created in 13:47 2020/9/10
 * @Description:
 */
public interface PermissionService {
    List<Permission> findByUserId(Integer userId);
}
