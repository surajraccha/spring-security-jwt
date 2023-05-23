package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/public")
	public String normal() {
		return "public";
	}
	

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
