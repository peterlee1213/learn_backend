package com.example.s04_seperate_front_end_and_back_end_authentication.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.example.s04_seperate_front_end_and_back_end_authentication.domain.SysUser;
import com.example.s04_seperate_front_end_and_back_end_authentication.repository.UserRepository;

import jakarta.annotation.Resource;

@Component
public class DBUserDetailsService implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser userItem = userRepository.findByUsername(username);
        if (userItem == null)
            throw new UsernameNotFoundException(username);
        else
            return User.builder().username(userItem.getUsername()).password(userItem.getPassword())
                    .disabled(!userItem.getEnabled()).build();
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // TODO Auto-generated method stub
        return null;
    }

}
