package com.example.gastroit.service;

import java.util.List;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.entity.Recipe;


public interface RecipeService {
	
	public void create(RecipeDTO recipe);
	
	public List<Recipe> list();

}
