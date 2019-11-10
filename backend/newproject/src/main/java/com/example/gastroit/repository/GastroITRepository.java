package com.example.gastroit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gastroit.model.dto.GastroITDTO;

@Repository
public interface GastroITRepository extends JpaRepository<GastroITDTO, Long>{

}
