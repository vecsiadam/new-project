package com.example.gastroit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gastroit.converter.IngredientConverter;
import com.example.gastroit.converter.RecipeConverter;
import com.example.gastroit.exception.RecipeNotFoundException;
import com.example.gastroit.exception.UnitNotFoundException;
import com.example.gastroit.model.dto.IngredientDTO;
import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.model.entity.Recipe;
import com.example.gastroit.model.entity.Unit;
import com.example.gastroit.repository.RecipeRepository;
import com.example.gastroit.repository.UnitRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	private final UnitRepository unitRepository;

	@Override
	public Recipe create(RecipeDTO recipe) {
		List<Unit> units = unitRepository.findAll();
		for (IngredientDTO ingredient : recipe.getIngredients()) {
			if (units.stream().noneMatch(u -> u.getName().equals(ingredient.getUnit()))) {
				throw new UnitNotFoundException(ingredient.getUnit());
			}
		}
		Recipe rec = RecipeConverter.convertToEntity(recipe, units);
		return recipeRepository.save(rec);
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
			List<Unit> units = unitRepository.findAll();
			for (IngredientDTO ingredient : updateRecipe.getIngredients()) {
				if (units.stream().noneMatch(u -> u.getName().equals(ingredient.getUnit()))) {
					throw new UnitNotFoundException(ingredient.getUnit());
				}
			}
			recipe.setIngredients(IngredientConverter.convertLitstToEntityList(updateRecipe.getIngredients(), units));
		}

		recipe.setModifierUser("MÓDOSÍTUSER");

		return recipeRepository.save(recipe);
	}

	@Override
	public void delete(Long recipeId) {
		recipeRepository.deleteById(recipeId);
	}

}
