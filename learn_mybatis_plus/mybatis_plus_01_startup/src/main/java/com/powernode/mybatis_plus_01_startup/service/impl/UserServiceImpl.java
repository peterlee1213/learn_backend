package com.powernode.mybatis_plus_01_startup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powernode.mybatis_plus_01_startup.domain.User;
import com.powernode.mybatis_plus_01_startup.mapper.UserMapper;
import com.powernode.mybatis_plus_01_startup.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    /**
     * Autowired会根据类型进行自动装配，这里是没问题的，因为通过@Mapper注解而创建的UserMapper实例只有一个
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

}
