package com.example.s02_user_authentication_based_on_database.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.example.s02_user_authentication_based_on_database.domain.Tuser;
import java.util.List;

public interface TuserRepository extends ListCrudRepository<Tuser, Integer> {
    Tuser findByUsername(String username);
}
