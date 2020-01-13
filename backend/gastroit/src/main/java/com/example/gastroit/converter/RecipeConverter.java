package com.example.gastroit.converter;

import java.util.List;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.dto.Status;
import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.model.entity.Unit;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class RecipeConverter {

	public static Recipe convertToEntity(final RecipeDTO recipeDTO, final List<Unit> units) {
		return new Recipe(recipeDTO.getName(),
				IngredientConverter.convertLitstToEntityList(recipeDTO.getIngredients(), units),
				recipeDTO.getDescription(), recipeDTO.getAuthor(), null, Status.WAITING);
	}
}
