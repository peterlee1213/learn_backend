package com.spring.jpa_04_define_query_methods.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.spring.jpa_04_define_query_methods.domain.Employees;

public interface DeriveQueryFromMethodNameRepository extends CrudRepository<Employees, Integer> {

    // 一般查询
    List<Employees> findByFirstNameOrLastName(String firstName, String lastName);

    // 排序
    List<Employees> findByLastNameOrderByEmpNoDesc(String lastName);

    // 可分页
    List<Employees> findAll(Pageable pageable);

}
