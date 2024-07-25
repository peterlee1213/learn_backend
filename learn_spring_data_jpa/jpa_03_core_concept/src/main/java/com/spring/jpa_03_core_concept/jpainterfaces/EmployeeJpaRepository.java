package com.spring.jpa_03_core_concept.jpainterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa_03_core_concept.domain.Employees;

public interface EmployeeJpaRepository extends JpaRepository<Employees, Integer> {

}
