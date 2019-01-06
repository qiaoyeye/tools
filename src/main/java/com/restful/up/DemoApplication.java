package com.restful.up;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.restful.up.model","com.restful.up.controller","com.restful.up.dao","com.restful.up.service"})

		//basePackages = { "com.cml.springboot.sample.db" }
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run( DemoApplication.class, args);

	}
}
