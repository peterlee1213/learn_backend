package com.example.jpa_09_related_query.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.example.jpa_09_related_query.domains.OptimisticLockTable;

public interface OptimisticLockRepository extends ListCrudRepository<OptimisticLockTable, Long> {

}
