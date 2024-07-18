package com.powernode.mybatis_plus_01_startup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.powernode.mybatis_plus_01_startup.mapper.UserMapper;

@SpringBootTest
class MybatisPlus01StartupApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
		System.out.println(userMapper);
	}

}
