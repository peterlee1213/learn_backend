package com.powernode.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.powernode.pojo.Car;

public interface CarMapper {

    /**
     * 当返回的对象没有一个POJO类可完美对应的时候应当使用一个Map集合来接收
     * 
     * @param id
     * @return
     */
    Map<String, Object> selectById(Long id);

    /**
     * 返回一个List的时候,如果我要找到某个id的对象我就需要遍历整个List,相反我可以创建一个大的Map集合,其key是对象的id,值是对象
     */
    @MapKey("id")
    Map<Long, Map<String, Object>> selectAll();

    /**
     * 返回结果跟POJO类不能一一对应的时候可以采用resultMap来将他们对应起来
     */
    List<Car> selectAllWithResultMap();

    /**
     * 测试mybatis自带的驼峰命名自动映射配置,
     * 比如可自动将字段guide_price映射为guidePrice
     */
    List<Car> selectMapUnderscoreToCamelCase();
}
