package com.example.springmicroservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmicroservices.entities.Department;
import com.example.springmicroservices.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside save department method of department service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentByDepartmentId(Long id) {
        log.info("Inside find department by id method of department service");
        return departmentRepository.findByDepartmentId(id);
    }


}
