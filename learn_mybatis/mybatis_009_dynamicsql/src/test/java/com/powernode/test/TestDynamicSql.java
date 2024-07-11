package com.powernode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * 测试set标签
     */
    @Test
    public void testUpdateWithSet() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.updateWithSet(new Car(1L, null, null, null, null, "随机"));
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 测试choose when otehrwise标签
     */
    @Test
    public void testSelectByChoose() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectByChoose(null, 11.0, "随机");
        System.out.println(list.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 使用foreach标签一次删除多条记录
     */
    @Test
    public void testDeleteByIds() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Object result = mapper.deleteByIds(new String[] { "12", "13" });
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 使用foreach标签一次插入多条记录
     */
    @Test
    public void testInsertMultipleWithForEach() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(null, "111", "文杰", 22.8, "2020-02-02", "燃油车"));
        carList.add(new Car(null, "222", "文杰", 22.8, "2020-02-02", "燃油车"));
        int count = mapper.insertMultipleCars(carList);
        System.out.println("total number of insertion:" + count);
        sqlSession.commit();
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 使用where or + foreach进行批量删除
     */
    @Test
    public void testDeleteByIdsWithWhereAndForEach() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Object result = mapper.deleteByIdsWithWhereAndForEach(new String[] { "14", "15" });
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 测试使用sql和include标签
     */
    @Test
    public void testUseSqlAndInclude() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> list = mapper.selectAllWithSqlAndInclude();
        System.out.println(list);
        sqlSession.close();
        SqlSessionUtil.close();
    }
}
