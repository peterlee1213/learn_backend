package com.example.s04_seperate_front_end_and_back_end_authentication.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.s04_seperate_front_end_and_back_end_authentication.domain.SysUser;

public interface UserRepository extends ListCrudRepository<SysUser, Integer> {
    SysUser findByUsername(String username);
}
