package com.powernode.mybatis_plus_01_startup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.powernode.mybatis_plus_01_startup.domain.User;

@Mapper
public interface UserMapper {

    public List<User> selectAll();

}
