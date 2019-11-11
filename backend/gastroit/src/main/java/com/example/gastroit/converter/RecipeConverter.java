package com.example.gastroit.converter;

import java.util.Date;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.dto.Status;
import com.example.gastroit.model.entity.Recipe;

public class RecipeConverter {

	public Recipe convertToEntity(final RecipeDTO recipeDTO) {
		return new Recipe(recipeDTO.getName(), recipeDTO.getIngredients(), recipeDTO.getDescription(),
				recipeDTO.getIngredients().size(), recipeDTO.getAuthor(), new Date(), null, null, Status.WAITING);
	}

	public RecipeDTO convertToDTO(final Recipe recipe) {
		return new RecipeDTO(recipe.getName(), recipe.getIngredients(), recipe.getDescription(), recipe.getAuthor());
	}
}
