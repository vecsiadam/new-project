package com.example.newproject.controller;

import java.util.HashSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newproject.model.dto.NewProjectDTO;

@RestController
@RequestMapping("/")
public class NewProjectController {
	
	@GetMapping(produces = "application/json")
	private NewProjectDTO firstEndPoint() {
		return new NewProjectDTO("Paprikás krumpli", new HashSet<String>(), "leírás", 2);
	}
}
