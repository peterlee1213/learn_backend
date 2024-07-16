package com.powernode.springboot3_004_configuration_file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan(basePackages = { "com.powernode.springboot3_004_configuration_file" })
@SpringBootApplication
public class Springboot3004ConfigurationFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3004ConfigurationFileApplication.class, args);
	}

}
