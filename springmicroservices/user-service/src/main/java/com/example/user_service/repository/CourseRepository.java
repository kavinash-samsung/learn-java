package com.example.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_service.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
