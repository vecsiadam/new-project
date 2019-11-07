package com.example.newproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.newproject.model.dto.NewProjectDTO;

@Repository
public interface NewProjectRepository extends JpaRepository<NewProjectDTO, Long>{

}
