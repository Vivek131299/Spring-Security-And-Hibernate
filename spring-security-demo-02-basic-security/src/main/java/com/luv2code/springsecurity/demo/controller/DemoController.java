package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
		
		// When we run our app, Spring will show its DEFAULT LOGIN PAGE, for us to login 
		// by using our users and passwords created in DemoSecurityConfig.java class.
		// And then it will Authenticate the user and password and THEN ONLY redirect us to 
		// home.jsp page.
		// Spring provides Default Login Page/Logic.
	}

}
