package com.example.gastroit.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.repository.RecipeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	@Override
	public Recipe create(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> list() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe update(Long recipeId, Recipe updateRecipe) {
		Recipe recipe = recipeRepository.findById(recipeId).get();
		if (recipe == null) {
			return null;
		}
		if (updateRecipe.getAuthor() != null) {
			recipe.setAuthor(updateRecipe.getAuthor());
		}
		if (updateRecipe.getDescription() != null) {
			recipe.setDescription(updateRecipe.getDescription());
		}
		if (updateRecipe.getName() != null) {
			recipe.setName(updateRecipe.getName());
		}
//		if(recipeDTO.getIngredients()!=null) {
//			recipe.setIngredients(recipeDTO.getIngredients());
//		}
		recipe.setModifiedDate(new Date());
//		recipe.setModifierUser(modifierUser);
		return recipeRepository.save(recipe);
	}

	@Override
	public void delete(Long recipeId) {
		recipeRepository.deleteById(recipeId);
	}

}
