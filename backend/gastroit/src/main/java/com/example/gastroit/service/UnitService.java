package com.example.gastroit.service;

import java.util.List;

import com.example.gastroit.model.entity.Unit;

public interface UnitService {

	Unit create(Unit unit);

	void delete(Long id);

	List<Unit> list();
}
