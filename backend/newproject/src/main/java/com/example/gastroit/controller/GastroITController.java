package com.example.gastroit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gastroit.model.dto.GastroITDTO;
import com.example.gastroit.service.GastroITServiceImpl;

@RestController
@RequestMapping("/")
public class GastroITController {
	
	@GetMapping(produces = "application/json")
	private List<GastroITDTO> list() {
		return service.list();
	}
	
	@Autowired
	private  GastroITServiceImpl service;
	
	@PostMapping(path = "/create", consumes = "application/json")
	public void create(@RequestBody GastroITDTO model) {
	    service.create(model);
	}
}
