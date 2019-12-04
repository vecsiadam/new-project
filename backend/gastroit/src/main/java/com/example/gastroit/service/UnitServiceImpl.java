package com.example.gastroit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gastroit.exception.UnitAlreadyExistException;
import com.example.gastroit.exception.UnitNotFoundException;
import com.example.gastroit.model.entity.Unit;
import com.example.gastroit.repository.UnitRepository;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	UnitRepository unitRepository;

	@Override
	public Unit create(Unit unit) {
		if (list().stream().anyMatch(u -> u.getName().equals(unit.getName()))) {
			throw new UnitAlreadyExistException();
		}
		return unitRepository.save(unit);
	}

	@Override
	public void delete(Long id) {
		if (list().stream().noneMatch(u -> u.getId().equals(id))) {
			throw new UnitNotFoundException();
		}
		unitRepository.deleteById(id);
	}

	@Override
	public List<Unit> list() {
		return unitRepository.findAll();
	}

}
