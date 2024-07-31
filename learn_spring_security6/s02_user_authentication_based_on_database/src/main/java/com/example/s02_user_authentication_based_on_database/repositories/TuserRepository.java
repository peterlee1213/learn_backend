package com.example.s02_user_authentication_based_on_database.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.example.s02_user_authentication_based_on_database.domain.Tuser;

public interface TuserRepository extends ListCrudRepository<Tuser, Integer> {

}
