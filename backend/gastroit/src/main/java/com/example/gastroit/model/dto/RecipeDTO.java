package com.example.gastroit.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RecipeDTO {

	private String name;
	private List<String> ingredients;
	private String description;
	private String author;

}
