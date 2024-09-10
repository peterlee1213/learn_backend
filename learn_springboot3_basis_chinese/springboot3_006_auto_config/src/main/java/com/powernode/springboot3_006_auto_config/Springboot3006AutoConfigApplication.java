package com.powernode.springboot3_006_auto_config;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;

@SpringBootApplication
public class Springboot3006AutoConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3006AutoConfigApplication.class, args);
	}

}
