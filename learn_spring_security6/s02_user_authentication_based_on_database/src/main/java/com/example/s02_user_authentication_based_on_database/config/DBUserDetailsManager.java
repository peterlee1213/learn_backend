package com.example.s02_user_authentication_based_on_database.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.example.s02_user_authentication_based_on_database.domain.Tuser;
import com.example.s02_user_authentication_based_on_database.repositories.TuserRepository;

import jakarta.annotation.Resource;

public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private TuserRepository tuserRepository;

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createUser(UserDetails userDetails) {
        Tuser tuser = new Tuser();
        tuser.setUsername(userDetails.getUsername());
        tuser.setPassword(userDetails.getPassword());
        tuser.setEnabled(userDetails.isEnabled());
        tuserRepository.save(tuser);
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
        Tuser userItem = tuserRepository.findByUsername(username);
        if (userItem == null) {
            throw new UsernameNotFoundException(username);
        } else {

            Collection<GrantedAuthority> authorities = new ArrayList<>();

            return new User(userItem.getUsername(), userItem.getPassword(), userItem.getEnabled(), true,
                    true, true,
                    authorities);
        }
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {

        return null;
    }

}
