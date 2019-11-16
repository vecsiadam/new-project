package com.example.gastroit.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.example.gastroit.model.dto.Status;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Recipe {

	// TODO: nem jó még az id generálás liquibase-zel
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rec_seq")
	@SequenceGenerator(name = "rec_seq")
	private Long id;
	private String name;
	// TODO: nem jó valamiért
	@ManyToMany
	private List<Ingredient> ingredients;
	private String description;
	private String author;
	private Date createdDate;
	private Date modifiedDate;
	private String modifierUser;
	@Enumerated(EnumType.STRING)
	private Status status;
}
