package com.example.gastroit.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.gastroit.model.dto.IngredientDTO;
import com.example.gastroit.model.entity.Ingredient;
import com.example.gastroit.model.entity.Unit;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class IngredientConverter {

	public static List<Ingredient> convertLitstToEntityList(final List<IngredientDTO> ingredientDTOs,
			final List<Unit> units) {
		List<Ingredient> ingredientList = new ArrayList<>();
		for (IngredientDTO ingredientDTO : ingredientDTOs) {
			Ingredient ingredient = new Ingredient(ingredientDTO.getName(), ingredientDTO.getNumber(),
					UnitConverter.convertToEntityToSave(ingredientDTO.getUnit(), units));
			ingredientList.add(ingredient);
		}
		return ingredientList;
	}
}
