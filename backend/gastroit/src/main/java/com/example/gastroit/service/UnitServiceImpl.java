package com.example.gastroit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gastroit.model.entity.Unit;
import com.example.gastroit.repository.UnitRepository;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	UnitRepository unitRepository;

	@Override
	public Unit create(Unit unit) {
		return unitRepository.save(unit);
	}

	@Override
	public void delete(Long id) {
		unitRepository.deleteById(id);
	}

	@Override
	public List<Unit> list() {
		return unitRepository.findAll();
	}

}
