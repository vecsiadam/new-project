package com.example.gastroit.service;

import java.util.List;

import com.example.gastroit.model.entity.Recipe;


public interface RecipeService {
	
	public void create(Recipe model);
	
	public List<Recipe> list();

}
