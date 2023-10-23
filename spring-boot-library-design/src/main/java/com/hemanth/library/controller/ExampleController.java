package com.hemanth.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hemanth.library.model.GreatLearning;
import com.hemanth.library.service.ExampleService;

//@Controller
@RestController
public class ExampleController {
	@Autowired
	ExampleService exampleService;
	@GetMapping("/info")
	//@ResponseBody
	public GreatLearning get() {
		return exampleService.get();
		
		
	}
	
	@PostMapping("customInfo")
	public GreatLearning customInfo(String courseName,String courseType, String instructorName) {
		return exampleService.customInfo(courseName, courseType, instructorName);
	}

}
