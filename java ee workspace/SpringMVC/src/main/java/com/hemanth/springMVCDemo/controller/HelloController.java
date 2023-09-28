package com.hemanth.springMVCDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String sayHello() {
		return "main-menu";
	}

}
