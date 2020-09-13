package com.wsw.wswclient1.service;

import com.wsw.wswclient1.entity.Hr;
import com.wsw.wswclient1.entity.Menu;
import com.wsw.wswclient1.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author WangSongWen
 * @Date 2020/9/13 下午8:42
 * @Description:
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusByHrId() {
        Integer id = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return menuMapper.getMenusByHrId(id);
    }
}
