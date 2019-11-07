package com.example.newproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newproject.model.dto.NewProjectDTO;
import com.example.newproject.service.NewProjectServiceImpl;

@RestController
@RequestMapping("/")
public class NewProjectController {
	
	@GetMapping(produces = "application/json")
	private List<NewProjectDTO> list() {
		return service.list();
	}
	
	@Autowired
	private  NewProjectServiceImpl service;
	
	@PostMapping(path = "/create", consumes = "application/json")
	public void create(@RequestBody NewProjectDTO model) {
	    service.create(model);
	}
}
