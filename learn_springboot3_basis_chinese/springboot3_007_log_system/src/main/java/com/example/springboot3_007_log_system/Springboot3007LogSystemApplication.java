package com.example.springboot3_007_log_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class Springboot3007LogSystemApplication {

	// 1. 声明日志记录器
	static Logger logger = LoggerFactory.getLogger(Springboot3007LogSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Springboot3007LogSystemApplication.class, args);

	}

}
