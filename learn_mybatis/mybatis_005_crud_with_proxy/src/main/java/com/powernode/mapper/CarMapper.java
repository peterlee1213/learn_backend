package com.powernode.mapper;

import java.util.List;

import com.powernode.pojo.Car;

public interface CarMapper {

    int insert(Car car);

    int deleteById(Long id);

    int update(Car car);

    Car selectById(Long id);

    List<Car> selectAll();

}
