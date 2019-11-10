package com.example.gastroit.model.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Recipe {

	public Recipe() {
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@ElementCollection
	private List<String> ingredients;
	private String description;
	private int ingridientsNumber;
	
}

