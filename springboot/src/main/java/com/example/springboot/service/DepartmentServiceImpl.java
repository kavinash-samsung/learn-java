package com.example.springboot.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Department;
import com.example.springboot.error.DepartmentNotFoundException;
import com.example.springboot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        LOGGER.info("i am logger info");
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment =  departmentRepository.findById(departmentId);
        LOGGER.info(String.format("Department with id %s not found", departmentId));
        if(!optionalDepartment.isPresent()){
            LOGGER.error(String.format("Department with id %s not found", departmentId));
            throw new DepartmentNotFoundException("Department not found");
        }
        return optionalDepartment.get();
        // try{
        //     return optionalDepartment.get();
        // }catch(NoSuchElementException e){
        //     return new Department();
        // }catch(Exception e){
        //     return new Department();
        // }
    }

    @Override
    public String deleteDepartmentById(Long departmentId){    
        departmentRepository.deleteById(departmentId);
        return "Delete department By Id: "+departmentId;
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentFromDb = null;
        try{
            departmentFromDb = departmentRepository.findById(departmentId).get();
        } catch(Exception e){

        }
        if(departmentFromDb != null && Objects.nonNull(department)
            && Objects.nonNull(department.getDepartmentName())     
            && !"".equalsIgnoreCase(department.getDepartmentName())
        ){
            departmentFromDb.setDepartmentName(department.getDepartmentName());
        }
        if(departmentFromDb != null && Objects.nonNull(department)
            && Objects.nonNull(department.getDepartmentCode())     
            && !"".equalsIgnoreCase(department.getDepartmentCode())
        ){
            departmentFromDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(departmentFromDb != null && Objects.nonNull(department)
            && Objects.nonNull(department.getDepartmentAddress())     
            && !"".equalsIgnoreCase(department.getDepartmentAddress())
        ){
            departmentFromDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(departmentFromDb);
        
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
    

}
