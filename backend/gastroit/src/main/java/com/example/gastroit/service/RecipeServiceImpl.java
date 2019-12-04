package com.example.gastroit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gastroit.converter.IngredientConverter;
import com.example.gastroit.converter.RecipeConverter;
import com.example.gastroit.exception.RecipeNotFoundException;
import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.repository.RecipeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	@Override
	public Recipe create(RecipeDTO recipe) {
		RecipeConverter recipeConverter = new RecipeConverter();
		return recipeRepository.save(recipeConverter.convertToEntity(recipe));
	}

	@Override
	public List<Recipe> list() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe update(Long recipeId, RecipeDTO updateRecipe) {

		if (list().stream().noneMatch(u -> u.getId().equals(recipeId))) {
			throw new RecipeNotFoundException();
		}

		Recipe recipe = recipeRepository.findById(recipeId).get();
		IngredientConverter ingredientConverter = new IngredientConverter();

		if (updateRecipe.getAuthor() != null) {
			recipe.setAuthor(updateRecipe.getAuthor());
		}
		if (updateRecipe.getDescription() != null) {
			recipe.setDescription(updateRecipe.getDescription());
		}
		if (updateRecipe.getName() != null) {
			recipe.setName(updateRecipe.getName());
		}
		if (updateRecipe.getIngredients() != null) {
			recipe.setIngredients(ingredientConverter.convertLitstToEntityList(updateRecipe.getIngredients()));
		}

		recipe.setModifierUser("MÓDOSÍTUSER");

		return recipeRepository.save(recipe);
	}

	@Override
	public void delete(Long recipeId) {
		recipeRepository.deleteById(recipeId);
	}

}
