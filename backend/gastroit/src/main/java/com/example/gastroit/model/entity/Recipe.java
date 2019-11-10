package com.example.gastroit.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.gastroit.model.dto.Status;

import lombok.Data;

@Data
@Entity
public class Recipe {

	public Recipe() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ElementCollection
	private List<String> ingredients;
	private String description;
	private int ingridientsNumber;
	private String author;
	private Date createdDate;
	private Date modifiedDate;
	private String modifierUser;
	@Enumerated(EnumType.STRING)
	private Status status;

	public Recipe(String name, List<String> ingredients, String description, int ingridientsNumber, String author,
			Date date, Date modifiedDate, String modifierUser, Status status) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.description = description;
		this.ingridientsNumber = ingridientsNumber;
		this.author = author;
		this.createdDate = date;
		this.modifiedDate = modifiedDate;
		this.modifierUser = modifierUser;
		this.status = status;
	}

}
