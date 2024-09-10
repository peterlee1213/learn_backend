package com.spring.jpa_06_projections.jpainterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa_06_projections.domain.Employees;
import com.spring.jpa_06_projections.dto.EmployeeName;

public interface ClassBasedProjectionRepository extends JpaRepository<Employees, Integer> {

    EmployeeName findByEmpNo(Integer empNo);

}
