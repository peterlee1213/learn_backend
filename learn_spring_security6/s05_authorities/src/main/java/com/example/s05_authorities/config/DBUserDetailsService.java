package com.example.s05_authorities.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.example.s05_authorities.domain.SysUser;
import com.example.s05_authorities.repository.UserRepository;

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
            return User.builder()
                    .username(userItem.getUsername())
                    .password(userItem.getPassword())
                    .disabled(!userItem.getEnabled())
                    // 对用户赋予“ADMIN_LIST”权限，注释掉的话就没有用户能访问/admin/list了
                    // .authorities("ADMIN_LIST")
                    // 下面这句话为用户分配角色
                    .roles("ADMIN")
                    .build();
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // TODO Auto-generated method stub
        return null;
    }

}
