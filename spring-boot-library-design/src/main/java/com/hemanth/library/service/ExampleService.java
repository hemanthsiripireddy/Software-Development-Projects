package com.hemanth.library.service;

import org.springframework.stereotype.Component;

import com.hemanth.library.model.GreatLearning;
@Component
public interface ExampleService {

	GreatLearning get();

	GreatLearning customInfo(String courseName, String courseType, String instructorName);

}