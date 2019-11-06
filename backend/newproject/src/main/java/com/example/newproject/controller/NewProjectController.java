package com.example.newproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NewProjectController {
	
	@GetMapping()
	private String firstEndPoint() {
		return "nyenyenye";
	}
}
