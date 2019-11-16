package com.example.gastroit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gastroit.model.entity.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

}
