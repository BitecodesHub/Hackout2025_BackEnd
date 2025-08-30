package com.Hackout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Hackout") 
public class HackoutApp {
	public static void main(String[] args) {
		SpringApplication.run(HackoutApp.class, args);
	}
}