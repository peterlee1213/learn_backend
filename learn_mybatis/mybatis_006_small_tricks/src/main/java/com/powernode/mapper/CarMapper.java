package com.powernode.mapper;

import java.util.List;

import com.powernode.pojo.Car;

public interface CarMapper {

    /**
     * 根据car_type获取汽车信息
     * 
     * @param carType
     * @return
     */
    List<Car> selectByCarType(String carType);

    /**
     * 升序或者降序获取所有汽车信息
     * 说明在什么场景中应当使用${}而非#{}
     * 
     * @param ascOrDesc asc|desc
     * @return
     */
    List<Car> selectAllByAscOrDesc(String ascOrDesc);

    /**
     * 根据id批量删除(where xxx in (1,2,3))
     * 
     * @param ids
     * @return
     */
    int deleteBarch(String ids);

    /**
     * 根据品牌模糊查询(where xxx like "%abc%")
     * 
     * @return
     */
    List<Car> selectByBrandLike(String produceTime);

    /**
     * 插入一个car并且在事务提交之前获取其key
     * 
     * @param car
     * @return
     */
    int insertCarAndgetGeneratedKey(Car car);
}
