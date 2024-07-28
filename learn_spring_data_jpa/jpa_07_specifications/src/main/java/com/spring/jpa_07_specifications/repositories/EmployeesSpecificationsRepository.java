package com.spring.jpa_07_specifications.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.jpa_07_specifications.domain.Employees;

public interface EmployeesSpecificationsRepository
        extends PagingAndSortingRepository<Employees, Integer>, JpaSpecificationExecutor<Employees> {

}
