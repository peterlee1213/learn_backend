package com.example.jpa_09_related_query.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.example.jpa_09_related_query.domains.Customer;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {

}
