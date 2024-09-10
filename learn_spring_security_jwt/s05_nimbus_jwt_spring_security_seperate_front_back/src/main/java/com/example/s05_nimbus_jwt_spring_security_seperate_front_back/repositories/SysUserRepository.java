package com.example.s05_nimbus_jwt_spring_security_seperate_front_back.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.s05_nimbus_jwt_spring_security_seperate_front_back.entities.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    Optional<SysUser> findUserByEmail(String email);
}
