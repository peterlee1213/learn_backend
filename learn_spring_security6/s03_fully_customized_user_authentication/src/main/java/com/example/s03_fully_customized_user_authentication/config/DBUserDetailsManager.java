package com.example.s03_fully_customized_user_authentication.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.example.s03_fully_customized_user_authentication.domain.SysUser;
import com.example.s03_fully_customized_user_authentication.repository.UserRepository;

import jakarta.annotation.Resource;

@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

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
        SysUser sysUser = new SysUser();
        sysUser.setUsername(user.getUsername());
        sysUser.setPassword(passwordEncoder.encode(user.getPassword()));
        sysUser.setEnabled(user.isEnabled());
        userRepository.save(sysUser);
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

    /**
     * 通过用户名从数据库中获取用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " Not Found");
        }
        return User.builder().username(username).password(user.getPassword())
                .disabled(!user.getEnabled()).build();
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // TODO Auto-generated method stub
        return null;
    }

}
