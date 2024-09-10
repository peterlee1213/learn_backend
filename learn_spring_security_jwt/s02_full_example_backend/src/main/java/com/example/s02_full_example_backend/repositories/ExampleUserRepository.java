package com.example.s02_full_example_backend.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.example.s02_full_example_backend.entities.ExampleUser;

public interface ExampleUserRepository extends ListCrudRepository<ExampleUser, Long> {
    Optional<ExampleUser> findByUserName(String userName);
}
