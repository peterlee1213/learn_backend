package com.powernode.mybatis_plus_01_startup.service;

import java.util.List;

import com.powernode.mybatis_plus_01_startup.domain.User;

public interface UserService {
    List<User> selectAll();
}
