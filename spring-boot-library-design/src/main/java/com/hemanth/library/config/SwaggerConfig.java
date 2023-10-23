package com.hemanth.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hemanth.library.service.ExampleService;
import com.hemanth.library.serviceImpl.ExampleServiceImpl;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig {
	@Bean
	public Docket libraryApi() {
		
		return new Docket(DocumentationType.SWAGGER_2).groupName("Library-API")
				.select().apis(RequestHandlerSelectors.basePackage("com.hemanth.library.controller") )
				.build();
		
	}
	
	@Bean
	public ExampleService exampleService() {
		return new ExampleServiceImpl();
	}

}
