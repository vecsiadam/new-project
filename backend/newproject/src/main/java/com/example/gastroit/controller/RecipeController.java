package com.example.gastroit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.service.RecipeServiceImpl;

@RestController
@RequestMapping("/")
public class RecipeController {
	
	@GetMapping(produces = "application/json")
	private List<RecipeDTO> list() {
		return service.list();
	}
	
	@Autowired
	private  RecipeServiceImpl service;
	
	@PostMapping(path = "/create", consumes = "application/json")
	public void create(@RequestBody RecipeDTO model) {
	    service.create(model);
	}
}
