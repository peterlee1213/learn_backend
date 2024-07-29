package com.example.security_06_config_role_privileges.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class WebSecurityConfig implements WebSecurityConfigurer {

    @Override
    public void configure(SecurityBuilder builder) throws Exception {

    }

    @Override
    public void init(SecurityBuilder builder) throws Exception {
        // TODO Auto-generated method stub

    }

}
