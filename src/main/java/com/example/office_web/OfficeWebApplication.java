package com.example.office_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.office_web.mapper")
@SpringBootApplication
public class OfficeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeWebApplication.class, args);
	}

}
