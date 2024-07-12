package com.powernode.mapper;

import com.powernode.pojo.Clazz;

public interface ClazzMapper {

    /**
     * student分步查询的第二步
     * 
     * @param cid
     * @return
     */
    Clazz selectByIdStep2(Long cid);

    /**
     * 一对多的collection查询方式(一个clazz对应多个学生)
     */
    Clazz selectByCollection(Long cid);

    /**
     * clazz分步查询的第一步
     */
    Clazz selectClazzByIdStep1(Long cid);
}
