package com.springbootdemo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication (
// 	scanBasePackages = {"com.springBootdemo.mycoolapp", "com.springBootdemo.util" })
@SpringBootApplication        
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

}
