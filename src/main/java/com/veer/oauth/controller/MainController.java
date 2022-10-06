package com.veer.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/hello/{name}")
	public String ShowHello(@PathVariable("name") String name) {
		return "Hello dear"+name+"...";
	}
	
	@GetMapping("/dashboard/{name}")
	public String ShowDashboard(@PathVariable("name") String name) {
		return "Welcome to your Dashboard Mr/Mrs. "+name+"...";
	}
	
	

}
