package com.example.s05_nimbus_jwt_spring_security_seperate_front_back.config.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.example.s05_nimbus_jwt_spring_security_seperate_front_back.entities.SysUser;
import com.example.s05_nimbus_jwt_spring_security_seperate_front_back.pojo.CustomUserDetails;
import com.example.s05_nimbus_jwt_spring_security_seperate_front_back.repositories.SysUserRepository;

import jakarta.annotation.Resource;

@Service
public class DBUserDetailsService implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private SysUserRepository sysUserRepository;

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createUser(UserDetails user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUser(String username) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUser(UserDetails user) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean userExists(String username) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<SysUser> userByEmail = sysUserRepository.findUserByEmail(email);
        if (userByEmail.isEmpty()) {
            throw new UsernameNotFoundException(email + " not found");
        }
        return new CustomUserDetails(userByEmail.get(),
                User.withUsername(email).password(userByEmail.get().getPassword()).accountExpired(false)
                        .accountLocked(false).disabled(userByEmail.get().getStatus() == '1').credentialsExpired(false)
                        .build());
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // TODO Auto-generated method stub
        return null;
    }

}
