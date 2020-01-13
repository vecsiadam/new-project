package com.example.gastroit.converter;

import java.util.List;

import com.example.gastroit.model.entity.Unit;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class UnitConverter {

	public static Unit convertToEntityToSave(final String unit, final List<Unit> units) {
		Unit result = null;
		for (Unit un : units) {
			if (un.getName().equals(unit)) {
				result = un;
			}
		}
		return result;
	}

	public static Unit convertToEntity(final String unit) {
		return new Unit(unit);
	}
}
