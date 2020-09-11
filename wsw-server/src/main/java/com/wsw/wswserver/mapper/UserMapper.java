package com.wsw.wswserver.mapper;

import com.wsw.wswserver.entity.User;

public interface UserMapper {
    User getUserByUserName(String username);
}

