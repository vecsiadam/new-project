package com.example.gastroit.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.gastroit.model.dto.IngredientDTO;
import com.example.gastroit.model.entity.Ingredient;

public class IngredientConverter {

	public Ingredient convertToEntity(IngredientDTO ingredientDTO) {
		return new Ingredient(ingredientDTO.getName(), ingredientDTO.getNumber(), ingredientDTO.getUnit());
	}

	public List<Ingredient> convertLitstToEntityList(List<IngredientDTO> ingredientDTOs) {
		List<Ingredient> ingredientList = new ArrayList<>();
		for (IngredientDTO ingredientDTO : ingredientDTOs) {
			Ingredient ingredient = new Ingredient(ingredientDTO.getName(), ingredientDTO.getNumber(),
					ingredientDTO.getUnit());
			ingredientList.add(ingredient);
		}
		return ingredientList;
	}
}
