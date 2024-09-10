package com.spring.jpa_06_projections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Jpa06ProjectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jpa06ProjectionsApplication.class, args);
	}

	@Bean("string")
	public String returnString() {
		return new String();
	}

}
