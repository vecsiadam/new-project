package com.example.gastroit.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingr_seq")
	@SequenceGenerator(name = "ingr_seq")
	Long id;

	String name;

	Double number;

	@OneToOne
	Unit unit;

}
