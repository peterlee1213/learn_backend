package com.spring.jpa_05_jpa_query_methods.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa_05_jpa_query_methods.domain.Employees;

public interface NamedQueryRepository extends JpaRepository<Employees, Integer> {

    /**
     * 测试最简单的Named Query
     * 注意： 这个simpleNamedQuery对应的查询语句放在实体类上
     * 
     * @param lastName
     * @return
     */
    List<Employees> simpleNamedQuery(String lastName);

}
