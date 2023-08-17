package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.binson.config, com.binson.controller,"
		+ "com.binson.service"})
public class SpringSecurityApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApp.class, args);
	}
}
