package com.example.springbootexampleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootExampleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleProjectApplication.class, args);
	}

}
