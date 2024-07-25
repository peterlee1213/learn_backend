package com.spring.jpa_05_jpa_query_methods.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa_05_jpa_query_methods.domain.Employees;

public interface QueryRepository extends JpaRepository<Employees, Integer> {

    @Query("select e from Employees e where e.empNo = ?1")
    Optional<Employees> findByEmpNo(Integer empNo);

    @Query("select e from Employees e where e.lastName like %?1%")
    List<Employees> advancedLikeExpression(String lastName);

    // 注意： 使用？1这种类型的变量写原生SQL语句的时候不能在前后加通配符
    @Query(value = "select * from employees where last_name = ?1", nativeQuery = true)
    List<Employees> nativeQuery(String lastName);

    // 如果返回的是page类型的变量则必须传Pageable参数，且需手动写countQuery以查询总数
    @Query(value = "select * from employees", countQuery = "select count(*) from employees", nativeQuery = true)
    Page<Employees> returnPage(Pageable pageable);
}
