package com.example.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_service.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
