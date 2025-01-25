package com.example.springboot.service;

import java.util.*;
import com.example.springboot.entity.Department;
import com.example.springboot.error.DepartmentNotFoundException;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    String deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
    
}
