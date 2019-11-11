package com.example.gastroit.service;

import java.util.List;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.entity.Recipe;

public interface RecipeService {

	RecipeDTO create(RecipeDTO recipe);

	List<Recipe> list();

	RecipeDTO update(String recipeId, RecipeDTO recipe);

}
