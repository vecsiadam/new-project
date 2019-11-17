package com.example.gastroit.model.dto;

import com.example.gastroit.model.entity.Unit;

import lombok.Data;

@Data
public class IngredientDTO {

	private String name;

	private Double number;

	private Unit unit;
}
