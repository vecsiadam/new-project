package com.example.gastroit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gastroit.model.dto.GastroITDTO;
import com.example.gastroit.repository.GastroITRepository;

@Service
public class GastroITServiceImpl {

	@Autowired
	private GastroITRepository newProjectRepository;

	public void create(GastroITDTO model) {
		newProjectRepository.save(model);
	}
	
	public List<GastroITDTO> list() {
		return newProjectRepository.findAll();
	}
}
