package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.example.*")
@EnableSwagger2
public class EntertainmentApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(EntertainmentApplication.class, args);

	}

}
