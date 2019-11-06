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
	
}
