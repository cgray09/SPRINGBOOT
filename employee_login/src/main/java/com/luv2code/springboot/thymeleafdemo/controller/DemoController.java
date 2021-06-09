package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	// create a mapping for "/hello"
	
	@GetMapping("/home")
	public String sayHello(Model theModel) {
		
		return "home";	// home.html
	}
	
	@GetMapping("/login")
	public String login(Model theModel) {
		
		return "login";	// login.html (this is for the login in the navbar not the post of the login  
	}		        // form)
}








