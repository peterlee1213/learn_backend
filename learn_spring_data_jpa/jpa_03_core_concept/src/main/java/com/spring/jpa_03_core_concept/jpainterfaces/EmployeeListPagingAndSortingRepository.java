package com.spring.jpa_03_core_concept.jpainterfaces;

import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.spring.jpa_03_core_concept.domain.Employees;

public interface EmployeeListPagingAndSortingRepository extends ListPagingAndSortingRepository<Employees, Integer> {

}
