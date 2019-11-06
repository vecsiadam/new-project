package com.example.newproject.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewProjectDTO {

	private String name;
	private Set<String> ingredients;
	private String description;
	private int ingridientsNumber;
	
//	public NewProjectDTO() {
//	}
//	
//	public NewProjectDTO(String name, Set<String> ingredients, String description, int ingridientsNumber) {
//		super();
//		this.name = name;
//		this.ingredients = ingredients;
//		this.description = description;
//		this.ingridientsNumber = ingridientsNumber;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public Set<String> getIngredients() {
//		return ingredients;
//	}
//	
//	public void setIngredients(Set<String> ingredients) {
//		this.ingredients = ingredients;
//	}
//	
//	public String getDescription() {
//		return description;
//	}
//	
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//	public int getIngridientsNumber() {
//		return ingridientsNumber;
//	}
//	
//	public void setIngridientsNumber(int ingridientsNumber) {
//		this.ingridientsNumber = ingridientsNumber;
//	}
	
}
