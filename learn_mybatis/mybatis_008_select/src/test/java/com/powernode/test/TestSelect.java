package com.powernode.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.mapper.CarMapper;
import com.powernode.pojo.Car;
import com.powernode.utils.SqlSessionUtil;

public class TestSelect {
    /**
     * 如果返回的对象刚好可以被POJO类接收自然最好
     * 在没有对应的POJO类最好使用Map来接收
     * 
     * 测试使用Map来接收返回的数据
     */
    @Test
    public void testGetResultWithMap() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> result = mapper.selectById(1L);
        System.out.println(result);
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 如果一个查询返回一个List,我想locate特定的id需要遍历,相反我可以返回一个大Map,其key是id,值就是此id对应的对象
     */
    @Test
    public void testSelectAllWithMapIdKey() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> result = mapper.selectAll();
        System.out.println(result.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 如果查询的结果跟POJO类的属性之间不能一对应, 可以通过resultMap解决
     */
    @Test
    public void testResultMap() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectAllWithResultMap();
        System.out.println(list.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 测试mybatis的驼峰命名自动映射配置
     */
    @Test
    public void testSelectMapUnderscoreToCamelCase() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectMapUnderscoreToCamelCase();
        System.out.println(list.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }
}
