package com.hemanth.library.serviceImpl;

import com.hemanth.library.model.FullName;
import com.hemanth.library.model.GreatLearning;
import com.hemanth.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ExampleServiceImpl implements ExampleService {
	@Override
	public GreatLearning get() {
		GreatLearning greatLearning= GreatLearning.builder().courseName("Learn Controllers in Spring boot")
				.courseType("IT")
				.instructorName(FullName.builder().firstName("Hemanth").lastName("Siripireddy").build())
				.build();
		log.info("Inside the get() method");
		
		return greatLearning;
		
	}
	@Override
	public GreatLearning customInfo(String courseName,String courseType, String instructorName) {
		GreatLearning greatLearning=GreatLearning.builder().courseName(courseName)
				.courseType(courseType).build();
		log.info("Inside the customInfo() method");
		
		return greatLearning;
	}

}
