package com.example.gastroit.service;

import java.util.List;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.entity.Recipe;

public interface RecipeService {

	Recipe create(RecipeDTO recipe);

	List<Recipe> list();

	Recipe update(Long recipeId, RecipeDTO recipe);

	void delete(Long recipeId);

}
