package com.example.gastroit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gastroit.model.dto.RecipeDTO;
import com.example.gastroit.repository.RecipeRepository;

@Service
public class RecipeServiceImpl {

	@Autowired
	private RecipeRepository newProjectRepository;

	public void create(RecipeDTO model) {
		newProjectRepository.save(model);
	}
	
	public List<RecipeDTO> list() {
		return newProjectRepository.findAll();
	}
}
