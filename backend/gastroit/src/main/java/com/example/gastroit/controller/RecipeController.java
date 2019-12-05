package com.example.gastroit.controller;

import java.util.List;

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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

	private final RecipeService recipeService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Recipe create(@RequestBody RecipeDTO recipe) {
		return recipeService.create(recipe);
	}

	@GetMapping(produces = "application/json")
	public List<Recipe> list() {
		return recipeService.list();
	}

	@PutMapping(path = "/{recipeId}", consumes = "application/json", produces = "application/json")
	public Recipe update(@PathVariable("recipeId") Long recipeId, @RequestBody RecipeDTO recipe) {
		return recipeService.update(recipeId, recipe);
	}

	@DeleteMapping(path = "/{recipeId}")
	public void delete(@PathVariable("recipeId") Long recipeId) {
		recipeService.delete(recipeId);
	}
}