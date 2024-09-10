package com.example.security_04_encrypt_password;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BCryptPasswordEncoderTest {

    @Test
    public void testBcrypt() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode1 = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("123456");
        String encode3 = passwordEncoder.encode("123456");

        /**
         * 默认输出的三个结果各不相同，因为有随机噪音（盐）
         */
        log.info(encode1);
        log.info(encode2);
        log.info(encode3);

        boolean match1 = passwordEncoder.matches("123456", encode1);
        boolean match2 = passwordEncoder.matches("123456", encode2);
        boolean match3 = passwordEncoder.matches("123456", encode3);

        /**
         * 但是使用match方法对比的时候都是相同的，以下输出都是true
         * 随即噪音信息也存储在encode之后的字符串中
         */
        log.info("" + match1);
        log.info("" + match2);
        log.info("" + match3);

        /**
         * 只要所有assert断言通过了就说明测试通过了
         */
        assertTrue(match1);
        assertTrue(match2);
        assertTrue(match3);
    }

}
