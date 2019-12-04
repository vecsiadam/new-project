package com.example.gastroit.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;

	@Column(name = "name")
	String name;

	@Column(name = "number")
	Double number;

	@OneToOne
	Unit unit;

	@ManyToMany(mappedBy = "ingredients")
	@JsonIgnore
	private List<Recipe> recipes = new ArrayList<>();

	public Ingredient(String name, Double number, Unit unit) {
		super();
		this.name = name;
		this.number = number;
		this.unit = unit;
	}

}
