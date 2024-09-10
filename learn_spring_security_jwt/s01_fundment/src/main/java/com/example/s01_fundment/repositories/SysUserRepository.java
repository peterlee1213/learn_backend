package com.example.s01_fundment.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.example.s01_fundment.entities.SysUser;

public interface SysUserRepository extends ListCrudRepository<SysUser, Long> {
    Optional<SysUser> findByUserName(String username);
}
