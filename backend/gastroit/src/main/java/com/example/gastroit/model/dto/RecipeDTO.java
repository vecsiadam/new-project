package com.example.gastroit.model.dto;

import java.util.List;

import com.example.gastroit.model.entity.Ingredient;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RecipeDTO {

	private String name;
	private String author;
	private List<Ingredient> ingredients;
	private String description;
}
