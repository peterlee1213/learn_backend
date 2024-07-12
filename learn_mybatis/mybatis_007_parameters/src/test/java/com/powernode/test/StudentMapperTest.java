package com.powernode.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.mapper.StudentMapper;
import com.powernode.pojo.Student;
import com.powernode.utils.SqlSessionUtil;

public class StudentMapperTest {

    /**
     * 根据id查询
     */
    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> result = mapper.selectById(1L);
        System.out.println(result.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 根据名称查询
     */
    @Test
    public void testSelectByName() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> selectByName = mapper.selectByName("m");
        System.out.println(selectByName.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 根据日期查询
     * 
     * @throws ParseException
     */
    @Test
    public void testSelectByBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date x = sdf.parse("2022-08-11");
        List<Student> list = mapper.selectByBirth(x);
        System.out.println(list.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 根据性别查询
     */
    @Test
    public void testSelectBySex() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> selectBySex = mapper.selectBySex('女');
        System.out.println(selectBySex.toString());
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 通过单个Map集合传参
     */
    @Test
    public void testInsertOneWithMap() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date x = null;
        try {
            x = sdf.parse("1999-09-09");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", "leonard");
        map.put("age", 22);
        map.put("height", 1.99);
        map.put("birth", x);
        map.put("sex", '女');
        int count = mapper.insertOneWithMap(map);
        if (count == 1) {
            System.out.println("insert success");
        }
        sqlSession.commit();
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 通过单个POJO类传参
     */
    @Test
    public void testInsertOneWithPOJO() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int insertOneWithPOJO = mapper.insertOneWithPOJO(new Student(null, "penny", 11, 1.77, new Date(), '女'));
        System.out.println(insertOneWithPOJO);
        sqlSession.commit();
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 通过名字和性别查询,传递多个参数
     */
    @Test
    public void testMultipleParameters() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> selectByNameAndSex = mapper.selectByNameAndSex("n", '女');
        System.out.println(selectByNameAndSex);
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 通过名字和性别查询,传递多个参数, 使用@Param注解消除掉arg0,arg1......而是使用有意义的参数名称
     * 这时候param1,param2.....这种方式还是可以使用的
     */
    @Test
    public void testMultipleParameters2() {
        SqlSession sqlSession = SqlSessionUtil.get();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> selectByNameAndSex = mapper.selectByNameAndSex2("n", '女');
        System.out.println(selectByNameAndSex);
        sqlSession.close();
        SqlSessionUtil.close();
    }
}
