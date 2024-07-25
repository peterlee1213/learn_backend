package com.spring.jpa_03_core_concept.jpainterfaces;

import org.springframework.data.repository.CrudRepository;

import com.spring.jpa_03_core_concept.domain.Employees;

public interface EmployeeCrudRepository extends CrudRepository<Employees, Integer> {

    // 除了接口已定义好的方法我还可以用自己的方法

}
