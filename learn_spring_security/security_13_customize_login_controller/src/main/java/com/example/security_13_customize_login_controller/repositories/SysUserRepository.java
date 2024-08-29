package com.example.security_13_customize_login_controller.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.example.security_13_customize_login_controller.entities.SysUser;

public interface SysUserRepository extends ListCrudRepository<SysUser, Long> {
    Optional<SysUser> findUserByUsername(String username);
}
