package com.example.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_service.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    
}