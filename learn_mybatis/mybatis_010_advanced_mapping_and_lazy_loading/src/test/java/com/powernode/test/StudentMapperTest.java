package com.powernode.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.mapper.StudentMapper;
import com.powernode.pojo.Student;
import com.powernode.utils.SqlSessionUtil;

public class StudentMapperTest {

    /**
     * 测试最基本的级联查询, 通过学生id查询学生信息以及其关联的班级信息
     */
    @Test
    public void testSelectStudentAndClassInfo() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = mapper.selectById("1");
        // System.out.println(stu.getSid());
        // System.out.println(stu.getSname());
        // System.out.println(stu.getClazz().getCid());
        // System.out.println(stu.getClazz().getCname());
        System.out.println(stu.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 测试association查询
     */
    @Test
    public void testSelectByIdAssociation() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = mapper.selectByIdAssociation("1");
        System.out.println(stu.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 分步查询,多个级联查询就分成多个sql语句
     */
    @Test
    public void testSelectByMiltiSteps() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = mapper.selectByIdStep1(1L);
        System.out.println(stu.getSname());
        System.out.println(stu.getClazz().getCname());
        sqlSession.close();
        SqlSessionUtil.close();
    }
}
