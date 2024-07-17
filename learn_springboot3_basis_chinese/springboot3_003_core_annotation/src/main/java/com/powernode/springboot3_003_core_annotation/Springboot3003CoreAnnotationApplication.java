package com.powernode.springboot3_003_core_annotation;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot3003CoreAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3003CoreAnnotationApplication.class, args);
	}

	@Bean
	public Date myDate() {
		return new Date();
	}
}
