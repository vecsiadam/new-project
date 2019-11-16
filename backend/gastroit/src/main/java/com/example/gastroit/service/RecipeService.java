package com.example.gastroit.service;

import java.util.List;

import com.example.gastroit.model.entity.Recipe;

public interface RecipeService {

	Recipe create(Recipe recipe);

	List<Recipe> list();

	Recipe update(Long recipeId, Recipe recipe);

	void delete(Long recipeId);

}
