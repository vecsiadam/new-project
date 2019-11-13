package com.example.gastroit.service;

import java.util.Date;
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
	private RecipeRepository recipeRepository;

	private RecipeConverter convert = new RecipeConverter();

	@Override
	public RecipeDTO create(RecipeDTO recipe) {
		return convert.convertToDTO((recipeRepository.save(convert.convertToEntity(recipe))));
	}

	@Override
	public List<Recipe> list() {
		return recipeRepository.findAll();
	}

	@Override
	public RecipeDTO update(Long recipeId, RecipeDTO recipeDTO) {
		Recipe recipe = recipeRepository.findById(recipeId).get();
		if (recipe == null) {
			return null;
		}		
		if(recipeDTO.getAuthor()!=null) {
			recipe.setAuthor(recipeDTO.getAuthor());
		}
		if(recipeDTO.getDescription()!=null) {
			recipe.setDescription(recipeDTO.getDescription());
		}
		if(recipeDTO.getName()!=null) {
			recipe.setName(recipeDTO.getName());
		}
		if(recipeDTO.getIngredients()!=null) {
			recipe.setIngredients(recipeDTO.getIngredients());
		}
		recipe.setModifiedDate(new Date());
//		recipe.setModifierUser(modifierUser);
		return convert.convertToDTO((recipeRepository.save(recipe)));
	}

}
