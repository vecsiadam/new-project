package com.example.gastroit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping(path = "/create-recipe", consumes = "application/json")
	public RecipeDTO create(@RequestBody RecipeDTO recipe) {
		return service.create(recipe);
	}

	@GetMapping(produces = "application/json")
	private List<Recipe> list() {
		return service.list();
	}

	@PostMapping(path = "/update-recipe/{recipeId}", consumes = "application/json")
	public RecipeDTO update(@PathVariable("recipeId") String recipeId, @RequestBody RecipeDTO recipe) {
		return service.update(recipeId, recipe);
	}

}
