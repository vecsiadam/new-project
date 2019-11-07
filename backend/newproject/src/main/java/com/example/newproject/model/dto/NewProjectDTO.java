package com.example.newproject.model.dto;

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
public class NewProjectDTO {
	
	public NewProjectDTO() {
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
