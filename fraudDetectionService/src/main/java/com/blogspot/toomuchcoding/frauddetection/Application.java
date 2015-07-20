package com.blogspot.toomuchcoding.frauddetection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ofg.infrastructure.config.EnableMicroservice;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableMicroservice
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
