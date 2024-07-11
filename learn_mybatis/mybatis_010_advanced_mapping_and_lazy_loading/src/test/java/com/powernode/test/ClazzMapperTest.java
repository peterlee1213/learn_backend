package com.powernode.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.mapper.ClazzMapper;
import com.powernode.pojo.Clazz;
import com.powernode.utils.SqlSessionUtil;

public class ClazzMapperTest {

    /**
     * 通过集合(collection)查询一个class中的多个学生
     */
    @Test
    public void testSelectByCollection() {
        SqlSession sqlSession = SqlSessionUtil.get();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz collection = mapper.selectByCollection(1000L);
        System.out.println(collection);
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 测试分步查询
     */
    @Test
    public void testSelectBySteps() {
        SqlSession sqlSession = SqlSessionUtil.get();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz collection = mapper.selectClazzByIdStep1(1000L);
        System.out.println(collection);
        sqlSession.close();
        SqlSessionUtil.close();
    }
}
