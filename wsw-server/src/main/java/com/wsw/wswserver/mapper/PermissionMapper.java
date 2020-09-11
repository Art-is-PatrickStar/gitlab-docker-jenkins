package com.wsw.wswserver.mapper;

import com.wsw.wswserver.entity.Permission;

import java.util.List;

/**
 * @Author WangSongWen
 * @Date: Created in 13:50 2020/9/10
 * @Description:
 */
public interface PermissionMapper {
    List<Permission> findByUserId(Integer id);
}
