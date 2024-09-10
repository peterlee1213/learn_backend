package com.example.jpa_09_related_query.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.example.jpa_09_related_query.domains.StudentClass;

public interface StudentClassRepository extends ListCrudRepository<StudentClass, Long> {

}
