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
import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.service.RecipeService;
import com.example.gastroit.service.RecipeServiceImpl;

@RestController
@RequestMapping("/")
public class RecipeController {
	
	@Autowired
	private  RecipeService service;
	
	@PostMapping(path = "/create", consumes = "application/json")
	public void create(@RequestBody Recipe model) {
	    service.create(model);
	}
	
	@GetMapping(produces = "application/json")
	private List<Recipe> list() {
		return service.list();
	}
}
