package com.hemanth.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hemanth.library.model.GreatLearning;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hello Springboot Sai");
		System.out.println("hello dev tools");
	}

	@Override
	public void run(String... args) throws Exception {
		GreatLearning greatLearning=new GreatLearning();
		greatLearning.setCourseName("Test Course");
		greatLearning.getCourseName();
		log.info("Great Leanring ->{}",greatLearning);
		System.out.println(greatLearning);

	}

}
