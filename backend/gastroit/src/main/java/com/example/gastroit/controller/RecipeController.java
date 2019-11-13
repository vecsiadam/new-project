package com.example.gastroit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.service.RecipeService;

@RestController
@RequestMapping("/")
public class RecipeController {

	@Autowired
	private RecipeService service;

	@PostMapping(path = "/create-recipe", consumes = "application/json", produces = "application/json")
	public RecipeDTO create(@RequestBody RecipeDTO recipe) {
		return service.create(recipe);
	}

	@GetMapping(produces = "application/json")
	public List<Recipe> list() {
		return service.list();
	}

	//TODO: update just recipe data without ingredients (ingredients update another endpoints)
	@PutMapping(path = "/update-recipe/{recipeId}", consumes = "application/json", produces = "application/json")
	public RecipeDTO update(@PathVariable("recipeId") Long recipeId, @RequestBody RecipeDTO recipe) {
		return service.update(recipeId, recipe);
	}
	
	@DeleteMapping(path = "/delete-recipe/{recipeId}")
	public void delete(@PathVariable("recipeId") Long recipeId) {
		service.delete(recipeId);
	}
	
	// TODO: add ingredients
	
	// TODO: rm ingredients
	
	// TODO: update just ingredients
	
}


// TODO: Liquibase, users api (spring security, login, registration) email sender api