package com.hemanth.springMVCDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hemanth.springMVCDemo.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		//create the object of student
		Student theStudent=new Student();
		theModel.addAttribute("student",theStudent);
		return "student-form";
	}
	@RequestMapping("/processForm")
	public String StringprocessForm(@ModelAttribute("student")Student theStudent) {
		
		System.out.println("The Student: "+theStudent.getFirstName());
		return "student-confirmation";
		
	}
	
	

}
