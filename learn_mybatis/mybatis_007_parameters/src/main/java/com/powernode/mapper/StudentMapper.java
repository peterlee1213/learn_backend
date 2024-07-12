package com.powernode.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.powernode.pojo.Student;

public interface StudentMapper {
    /**
     * 当接口中的方法的参数只有一个,并且参数的数据类型都是简单类型
     * 根据id查询,name查询,birth查询,sex查询
     */
    List<Student> selectById(Long id);

    List<Student> selectByName(String name);

    List<Student> selectByBirth(Date birth);

    List<Student> selectBySex(Character sex);

    /**
     * 通过Map参数保存学生信息, 单个参数, 但是参数类型是map集合而非简单类型
     * 
     * @param map
     * @return
     */
    int insertOneWithMap(Map<String, Object> map);

    /**
     * 通过POJO类传参,单个参数
     */
    int insertOneWithPOJO(Student student);

    /**
     * 根据名字和性别查询,传多个参数, arg0, arg1 .....
     */
    List<Student> selectByNameAndSex(String name, Character sex);

    /**
     * 根据名字和性别查询,传多个参数且使用@Param注解, 消灭arg0,arg1....
     * 
     * @Param 注解中的值就是mybatis接收到的参数类型
     */
    List<Student> selectByNameAndSex2(@Param("name") String name, @Param("sex") Character sex);
}
