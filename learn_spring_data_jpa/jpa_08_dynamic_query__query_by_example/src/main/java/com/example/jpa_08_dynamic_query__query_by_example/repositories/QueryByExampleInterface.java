package com.example.jpa_08_dynamic_query__query_by_example.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.jpa_08_dynamic_query__query_by_example.domains.Employees;

public interface QueryByExampleInterface
        extends PagingAndSortingRepository<Employees, Integer>, QueryByExampleExecutor<Employees> {

}
