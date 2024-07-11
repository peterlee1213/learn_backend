package com.powernode.mapper;

import java.util.List;

import com.powernode.pojo.Student;

public interface StudentMapper {

    /**
     * 级联获取学生信息以及其关联的班级信息
     * 
     * @param id
     * @return
     */
    Student selectById(String sid);

    /**
     * 一条SQL语句, 通过association方式查询学生以及其关联的班级信息
     */
    Student selectByIdAssociation(String id);

    /**
     * 获取学生信息
     * 分部查询第一步: 根据学生sid查询学生信息
     */
    Student selectByIdStep1(Long sid);

    /**
     * 获取clazz的分步查询第二步
     */
    List<Student> selectClazzByIdStep2(Long cid);

}
