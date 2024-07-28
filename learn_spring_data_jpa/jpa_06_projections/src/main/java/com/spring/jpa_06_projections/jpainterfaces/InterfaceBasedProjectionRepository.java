package com.spring.jpa_06_projections.jpainterfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jpa_06_projections.domain.Employees;
import com.spring.jpa_06_projections.domaininterface.EmployeeName;

public interface InterfaceBasedProjectionRepository extends JpaRepository<Employees, Integer> {

    EmployeeName findByLastName(String lastName);

    EmployeeName findByEmpNo(Integer empNo);

    @Query("select e from Employees e where empNo = :empNo")
    EmployeeName findByEmpNoHandWrite(@Param("empNo") Integer empNo);

}
