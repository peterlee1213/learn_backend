package com.spring.jpa_05_jpa_query_methods.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.spring.jpa_05_jpa_query_methods.domain.Employees;

import jakarta.persistence.QueryHint;

public interface QueryRepository extends JpaRepository<Employees, Integer> {

    @Query("select e from Employees e where e.empNo = ?1")
    Optional<Employees> findByEmpNo(Integer empNo);

    // 只有在JPQL中才可以在?1这种变量前后加%
    @Query("select e from Employees e where e.lastName like %?1%")
    List<Employees> advancedLikeExpression(String lastName);

    // 注意： 使用?1这种类型的变量写原生SQL语句的时候不能在前后加通配符
    @Query(value = "select * from employees where last_name = ?1", nativeQuery = true)
    List<Employees> nativeQuery(String lastName);

    // 如果返回的是page类型的变量则必须传Pageable参数，且需手动写countQuery以查询总数
    @Query(value = "select * from employees", countQuery = "select count(*) from employees", nativeQuery = true)
    Page<Employees> returnPage(Pageable pageable);

    // 自定义JPQL手写sort
    @Query("select e from Employees e")
    List<Employees> findAllAndSort(Sort sort);

    // 测试Named parameters
    @Query("select e from Employees e where e.lastName like %:lastName%")
    List<Employees> findByLastNameTestNamedParameter(@Param("lastName") String lastName);

    // 测试使用entityName来代替bean的名称
    @Query("select e from #{#entityName} e")
    List<Employees> findAllTestEntityName();

    // 测试使用escape方法- 1. 没有escape方法下的效果
    @Query("select e from #{#entityName} e where e.lastName like :lastName")
    List<Employees> findByLastNameTestWithoutEscape(@Param("lastName") String lastName);

    // 测试使用escape方法- 2. 有escape方法的效果
    // ?#{[0]}等同于?1, 要使用escape方法只能通过这种格式引用参数
    @Query("select e from #{#entityName} e where e.lastName like ?#{escape([0])} escape ?#{escapeCharacter()}")
    List<Employees> findByLastNameTestWithEscape(@Param("lastName") String lastName);

    // 所有update语句都要在@Query上加@Modifying注解
    @Modifying
    @Query("update Employees e set e.firstName = :firstName where empNo = :empNo")
    int updateFirstNameById(@Param("firstName") String firstName, @Param("empNo") Integer empNo);

    // 删除
    // 1. derive SQL from method name
    void deleteByEmpNo(Integer empNo);

    // 2. 手动写JPQL语句
    @Modifying
    @Query("delete from Employees e where e.empNo = :empNo")
    void deleteByEmpNoWithQuery(Integer empNo);

    // @QueryHints(value = { @QueryHint(name = "name", value = "value") },
    // forCounting = false)
    // Page<Employees> findByLastName(String lastName, Pageable pageable);

}
