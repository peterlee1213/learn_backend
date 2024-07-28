package com.spring.jpa_06_projections.jpainterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa_06_projections.domain.Employees;

public interface DynamicProjectionRepository extends JpaRepository<Employees, Integer> {
    <T> T findByEmpNo(Integer empNo, Class<T> type);
}
