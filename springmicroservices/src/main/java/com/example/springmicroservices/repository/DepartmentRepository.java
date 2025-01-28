package com.example.springmicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springmicroservices.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    Department findByDepartmentId(Long id);
    
}
