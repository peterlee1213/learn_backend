package com.example.security_13_customize_login_controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login").anonymous()
                .anyRequest().authenticated());

        http.httpBasic(Customizer.withDefaults());

        // 注意：必须要关闭formLogin才能让/login的post请求走自定义的Controller
        // http.formLogin(Customizer.withDefaults());

        http.csrf(csrf -> {
            csrf.disable();
        });

        http.securityContext(context -> context
                /**
                 * when requireExplicitSave is true, Spring Security sets up the
                 * SecurityContextHolderFilter instead of the SecurityContextPersistenceFilter
                 */
                .requireExplicitSave(true));

        return http.build();
    }

    // 重写AuthenticationManager这样可以自定义ProviuderManager中的AuthenticationProvider
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        /**
         * DaoAuthenticationProvider是AuthenticationProvider的一个implementation,
         * 通过UserDetailsService和PasswordEncoder来验证用户名和密码
         * UserDetailsService是一个service,通过loadUserByUsername方法获取UserDetails
         */
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        ProviderManager providerManager = new ProviderManager(authenticationProvider);
        // 通过这行代码可关闭抹除密码的操作，即Authentication.getCredentials()可直接获取到用户密码（明文）
        providerManager.setEraseCredentialsAfterAuthentication(false);
        return providerManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}