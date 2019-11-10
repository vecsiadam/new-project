package com.example.gastroit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gastroit.converter.RecipeDTOToRecipeConverter;
import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository newProjectRepository;

	@Override
	public void create(RecipeDTO recipe) {
		RecipeDTOToRecipeConverter convert = new RecipeDTOToRecipeConverter();
		newProjectRepository.save(convert.converter(recipe));
	}

	@Override
	public List<Recipe> list() {
		return newProjectRepository.findAll();
	}

}
