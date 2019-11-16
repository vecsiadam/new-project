package com.example.gastroit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gastroit.model.entity.Unit;
import com.example.gastroit.service.UnitService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/unit")
@AllArgsConstructor
public class UnitController {

	private final UnitService unitService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Unit create(@RequestBody Unit unit) {
		return unitService.create(unit);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public void delete(@PathVariable("id") Long id) {
		unitService.delete(id);
	}

	@GetMapping(produces = "application/json")
	public List<Unit> list() {
		return unitService.list();
	}
}
