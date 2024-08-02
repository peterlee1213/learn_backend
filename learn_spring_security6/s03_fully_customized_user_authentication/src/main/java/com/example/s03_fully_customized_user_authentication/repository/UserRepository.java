package com.example.s03_fully_customized_user_authentication.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.s03_fully_customized_user_authentication.domain.SysUser;

public interface UserRepository extends ListCrudRepository<SysUser, Integer> {
    SysUser findByUsername(String username);
}
