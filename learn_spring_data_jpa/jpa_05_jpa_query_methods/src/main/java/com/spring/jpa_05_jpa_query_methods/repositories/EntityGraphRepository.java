package com.spring.jpa_05_jpa_query_methods.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa_05_jpa_query_methods.domain.Employees;

public interface EntityGraphRepository extends JpaRepository<Employees, Integer> {
    
}
