package com.example.gastroit.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.gastroit.model.dto.IngredientDTO;
import com.example.gastroit.model.entity.Ingredient;
import com.example.gastroit.model.entity.Unit;

public class IngredientConverter {

	public List<Ingredient> convertLitstToEntityList(final List<IngredientDTO> ingredientDTOs, final List<Unit> units) {
		UnitConverter unitConverter = new UnitConverter();
		List<Ingredient> ingredientList = new ArrayList<>();
		for (IngredientDTO ingredientDTO : ingredientDTOs) {
			Ingredient ingredient = new Ingredient(ingredientDTO.getName(), ingredientDTO.getNumber(),
					unitConverter.convertToEntityToSave(ingredientDTO.getUnit(), units));
			ingredientList.add(ingredient);
		}
		return ingredientList;
	}
}
