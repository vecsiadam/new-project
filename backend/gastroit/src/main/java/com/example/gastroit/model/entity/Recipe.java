package com.example.gastroit.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.example.gastroit.model.dto.Status;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
	private List<Ingredient> ingredients;

	@Column(name = "description")
	private String description;

	@Column(name = "author")
	private String author;

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "modifiedDate")
	private Date modifiedDate;

	@Column(name = "modifierUser")
	private String modifierUser;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	public Recipe(String name, List<Ingredient> ingredients, String description, String author, Date createdDate,
			Date modifiedDate, String modifierUser, Status status) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.description = description;
		this.author = author;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.modifierUser = modifierUser;
		this.status = status;
	}

}
