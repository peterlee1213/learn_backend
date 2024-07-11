package com.powernode.mapper;

import java.util.List;
import java.util.Map;

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

        /**
         * 测试set标签,set标签好处如下:
         * 1. 自动去掉最后一个赋值字段多余的逗号
         * 2. 如果某个字段的值是null或者"",可自动跳过该字段的更新
         */
        int updateWithSet(Car car);

        /**
         * 测试choose when otherwise标签
         * 类似于编程语言中的switch case语句
         * <choose>
         * <when></when>
         * <when></when>
         * <when></when>
         * <when></when>
         * <otherwise></otherwise>
         * </choose>
         */
        List<Car> selectByChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice,
                        @Param("carType") String carType);

        /**
         * 使用foreach标签一次删除多条记录
         */
        int deleteByIds(@Param("ids") String[] ids);

        /**
         * 使用foreach标签一次插入多条记录
         */
        int insertMultipleCars(@Param("cars") List<Car> cars);

        /**
         * 使用where or语法+foreach进行批量删除
         */
        int deleteByIdsWithWhereAndForEach(@Param("ids") String[] ids);

        /**
         * 测试sql标签与include标签
         * sql标签用来声明sql片段
         * include标签用来将声明的片段插入到某个sql语句中
         */
        List<Map<String, Object>> selectAllWithSqlAndInclude();
}
