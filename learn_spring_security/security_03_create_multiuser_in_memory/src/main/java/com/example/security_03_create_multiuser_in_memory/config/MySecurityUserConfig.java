package com.example.security_03_create_multiuser_in_memory.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义类实现UserDetailsService接口，loadUserByUsername根据用户名找到用户细节信息
 * 比如用户名和密码，或者用户全新鲜，用户是否被锁定等等，具体看这个方法返回的UserDetails
 * 对象
 */

@Service // 如果spring容器没有这个接口的bean，spring会给我们创建一个，有的话就用这个bean
public class MySecurityUserConfig implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user1 = User.builder().username("zhangsan").password("123456").build();
        UserDetails user2 = User.builder().username("lisi").password("123456").build();
    }

}
