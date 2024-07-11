package com.powernode.mapper;

import com.powernode.pojo.Car;

public interface CarMapper {

    /**
     * 测试一级缓存
     * 
     * @param id
     * @return
     */
    Car selectById(Long id);

    /**
     * 测试二级缓存
     */
    Car selectById2(Long id);

}
