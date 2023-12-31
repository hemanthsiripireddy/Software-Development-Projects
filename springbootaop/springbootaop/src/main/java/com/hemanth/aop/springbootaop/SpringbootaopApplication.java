package com.hemanth.aop.springbootaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.hemanth.aop.springbootaop.*")
@EnableSwagger2
public class SpringbootaopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootaopApplication.class, args);
	}

}
