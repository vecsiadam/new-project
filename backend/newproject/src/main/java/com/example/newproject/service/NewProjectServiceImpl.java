package com.example.newproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newproject.model.dto.NewProjectDTO;
import com.example.newproject.repository.NewProjectRepository;

@Service
public class NewProjectServiceImpl {

	@Autowired
	private NewProjectRepository newProjectRepository;

	public void create(NewProjectDTO model) {
		newProjectRepository.save(model);
	}
	
	public List<NewProjectDTO> list() {
		return newProjectRepository.findAll();
	}
}
