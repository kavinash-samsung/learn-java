package com.example.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_service.entities.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long>{
    
}
