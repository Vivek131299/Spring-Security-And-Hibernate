package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage") // This is based on our Spring Security Config file.(See DemoSecurityConfig.java class).
	public String showMyLoginPage() {
		
		return "plain-login";
	}
}
