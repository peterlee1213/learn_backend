package com.example.s03_oauth2_resource_server.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.s03_oauth2_resource_server.domain.SysUser;

public interface UserRepository extends ListCrudRepository<SysUser, Integer> {
    SysUser findByUsername(String username);
}
