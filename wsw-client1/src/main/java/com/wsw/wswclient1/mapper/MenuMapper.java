package com.wsw.wswclient1.mapper;

import com.wsw.wswclient1.entity.Menu;

import java.util.List;

/**
 * @Author WangSongWen
 * @Date 2020/9/13 下午9:16
 * @Description:
 */
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByHrId(Integer id);
}
