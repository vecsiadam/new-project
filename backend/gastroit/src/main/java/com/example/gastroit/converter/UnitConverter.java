package com.example.gastroit.converter;

import java.util.List;

import com.example.gastroit.model.entity.Unit;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UnitConverter {

	public Unit convertToEntityToSave(final String unit, final List<Unit> units) {
		Unit result = null;
		for (Unit un : units) {
			if (un.getName().equals(unit)) {
				result = un;
			}
		}
		return result;
	}

	public Unit convertToEntity(final String unit) {
		return new Unit(unit);
	}
}
