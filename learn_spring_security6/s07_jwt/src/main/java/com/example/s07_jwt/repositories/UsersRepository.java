package com.example.s07_jwt.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.s07_jwt.domains.Users;

public interface UsersRepository extends ListCrudRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByVerificationCode(String verificationCode);
}
