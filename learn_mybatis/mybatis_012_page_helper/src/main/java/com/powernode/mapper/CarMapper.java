package com.powernode.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.powernode.pojo.Car;

public interface CarMapper {
    /**
     * 分页查询car
     */
    List<Car> selectCarByPages();
}
