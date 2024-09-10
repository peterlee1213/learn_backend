package com.example.s05_nimbus_jwt_spring_security_seperate_front_back.config.security;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;

public class JWTUtil {

    private static final String password = "abcdefgehergiuwegbgweuhfgiuwehguiwejugbniweughweiugh";
    // 证书有效时间
    private static final Integer validSeconds = 3600;

    /**
     * generate jwt with given {@Code Authentication} Object
     * 
     * @param authentication the {@Code Authentication} Object used to generate jwt
     * @return jwt if success, null if failed
     */
    public static String generateJWT(Authentication authentication) {
        Map<String, Object> map = new HashMap<>();
        Instant now = Instant.now();

        map.put("authentication", authentication);
        map.put("issueTime", now);
        map.put("expiry", now.plusSeconds(validSeconds));

        // 注意：new Payload的时候可以选择很多类型的参数，比如可以是字符串/Map对象/base64编码/JWSObject等等
        // 这句话定义了jwt的第一部分和第二部分，即「digest方法」和「payload」
        JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS384), new Payload(map));

        try {
            // new MACSigner的时候注意长度要求
            jwsObject.sign(new MACSigner(password));
            // JWSObject的serialize（）方法将jwt转化成为点号分割的base64 encoded格式
            String jwt = jwsObject.serialize();
            return jwt;
        } catch (JOSEException e) {
            e.printStackTrace();
            return null;
        }
    }

    // public static Authentication validateJWT() {
    // // 1. 是否能成功通过hash验证
    // // 2. 是否能
    // }
}
