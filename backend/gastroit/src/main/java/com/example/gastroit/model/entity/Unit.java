package com.example.gastroit.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq")
	@SequenceGenerator(name = "unit_seq")
	Long id;

	String name;
}
