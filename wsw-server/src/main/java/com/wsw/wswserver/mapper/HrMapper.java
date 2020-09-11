package com.wsw.wswserver.mapper;

import com.wsw.wswserver.entity.Hr;

/**
 * @Author WangSongWen
 * @Date: Created in 10:09 2020/9/11
 * @Description:
 */
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);
}
