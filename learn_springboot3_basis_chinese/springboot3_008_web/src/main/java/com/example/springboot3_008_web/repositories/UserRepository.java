package com.example.springboot3_008_web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.example.springboot3_008_web.domain.User;

public interface UserRepository extends ListCrudRepository<User, Integer> {

}
