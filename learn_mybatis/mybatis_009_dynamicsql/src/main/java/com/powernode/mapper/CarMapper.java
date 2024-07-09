package com.powernode.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.powernode.pojo.Car;

public interface CarMapper {

    /**
     * 使用if关键字构建不同过滤参数下的sql语句
     * 
     * @return
     */
    List<Car> selectByIfFilter(@Param("brand") String brand, @Param("guidePrice") Double guidePrice,
            @Param("carType") String carType);

    /**
     * 使用where标签构建where子句动态查询
     * 
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByIfFilterWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice,
            @Param("carType") String carType);

    /**
     * 使用trim标签
     * 
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByIfFilterWithTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice,
            @Param("carType") String carType);

}
