package com.example.s01_fundment;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.s01_fundment.entities.SysUser;
import com.example.s01_fundment.repositories.SysUserRepository;
import com.example.s01_fundment.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;

@SpringBootTest
public class TestBasicJWT {

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 测试passwordEncoder
     */
    @Test
    public void generatePassword() {
        String code = passwordEncoder.encode("123456");
        System.out.println(code);
    }

    /**
     * 测试生成并解析jwt是否正常工作
     * 
     * @throws Exception
     */
    @Test
    public void generateJWT() throws Exception {

        // 生成jwt
        String jwt = JwtUtil.createJWT("abc", null);
        System.out.println(jwt);

        // 解析jwt
        Claims jwt2 = JwtUtil.parseJWT(jwt);
        System.out.println(jwt2.getId());
        System.out.println(jwt2);
    }

    /**
     * 测试数据库连接是否成功
     */
    @Test
    public void testDBConnection() {
        Optional<SysUser> userItem = sysUserRepository.findByUserName("admin");
        System.out.println(userItem);
    }

}
