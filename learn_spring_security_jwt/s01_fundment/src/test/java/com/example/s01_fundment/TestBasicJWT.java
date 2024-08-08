package com.example.s01_fundment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.s01_fundment.utils.JwtUtil;

import io.jsonwebtoken.Claims;

// @SpringBootTest
public class TestBasicJWT {

    @Test
    public void generateJWT() throws Exception {

        // 生成jwt
        String jwt = JwtUtil.createJWT("uuid", "abc", null);
        System.out.println(jwt);

        // 解析jwt
        Claims jwt2 = JwtUtil.parseJWT(jwt);
        System.out.println(jwt2.getId());
        System.out.println(jwt2);
    }

}
