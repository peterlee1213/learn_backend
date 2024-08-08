package com.example.s02_full_example_backend.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.example.s02_full_example_backend.entities.ExampleUser;
import com.example.s02_full_example_backend.repositories.ExampleUserRepository;

import jakarta.annotation.Resource;

@Component
public class DBUserDetailsService implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private ExampleUserRepository exampleUserRepository;

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
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ExampleUser> userItem = exampleUserRepository.findByUserName(username);
        try {

            Collection<GrantedAuthority> collection = new HashSet<GrantedAuthority>();
            collection.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "student";
                }
            });

            ExampleUser exampleUser = userItem.get();
            return new CustomUserDetail(exampleUser.getId(), exampleUser.getUserName(), exampleUser.getPassword(),
                    exampleUser.getEnabled(), exampleUser.getPhoneNumber(), collection);
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(username + " not found", e);
        }

    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // TODO Auto-generated method stub
        return null;
    }

}
