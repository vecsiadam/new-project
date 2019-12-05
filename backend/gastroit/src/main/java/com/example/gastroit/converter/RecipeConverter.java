package com.example.gastroit.converter;

import java.util.List;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.dto.Status;
import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.model.entity.Unit;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RecipeConverter {

	public Recipe convertToEntity(final RecipeDTO recipeDTO, final List<Unit> units) {
		IngredientConverter ingredientConverter = new IngredientConverter();
		return new Recipe(recipeDTO.getName(),
				ingredientConverter.convertLitstToEntityList(recipeDTO.getIngredients(), units),
				recipeDTO.getDescription(), recipeDTO.getAuthor(), null, Status.WAITING);
	}
}
