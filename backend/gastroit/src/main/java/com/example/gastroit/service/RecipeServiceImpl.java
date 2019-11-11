package com.example.gastroit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gastroit.converter.RecipeConverter;
import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository RecipeRepository;

	private RecipeConverter convert = new RecipeConverter();

	@Override
	public RecipeDTO create(RecipeDTO recipe) {
		return convert.convertToDTO((RecipeRepository.save(convert.convertToEntity(recipe))));
	}

	@Override
	public List<Recipe> list() {
		return RecipeRepository.findAll();
	}

	@Override
	public RecipeDTO update(String recipeId, RecipeDTO recipe) {

		return null;
	}

}
