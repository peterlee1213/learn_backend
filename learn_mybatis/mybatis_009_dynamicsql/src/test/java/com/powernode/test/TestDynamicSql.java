package com.powernode.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.mapper.CarMapper;
import com.powernode.pojo.Car;
import com.powernode.util.SqlSessionUtil;

public class TestDynamicSql {

    /**
     * 测试if标签
     */
    @Test
    public void testSelectByIfFilter() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> selectByIfFilter = mapper.selectByIfFilter(null, 10.0, "燃油车");
        System.out.println(selectByIfFilter.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 测试where标签
     */
    @Test
    public void testSelectByIfFilterWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> selectByIfFilter = mapper.selectByIfFilterWithWhere(null, 10.0, "燃油车");
        System.out.println(selectByIfFilter.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 测试trim标签
     */
    @Test
    public void testSelectByIfFilterWithTrim() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> selectByIfFilter = mapper.selectByIfFilterWithTrim(null, null, "");
        System.out.println(selectByIfFilter.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }
}
