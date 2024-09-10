package com.example.s05_authorities.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.s05_authorities.domain.SysUser;

public interface UserRepository extends ListCrudRepository<SysUser, Integer> {
    SysUser findByUsername(String username);
}
