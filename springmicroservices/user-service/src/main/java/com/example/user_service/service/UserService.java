package com.example.user_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user_service.VO.Department;
import com.example.user_service.VO.ResponseTemplateVO;
import com.example.user_service.entities.UserClass;
import com.example.user_service.repository.UserClassRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserClassRepository userClassRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserClass saveUser(UserClass user) {
        log.info("Inside save User method of User service");
        return userClassRepository.save(user);
    }

    public UserClass findUserByUserId(Long id) {
        log.info("Inside find User by id method of User service");
        return userClassRepository.findById(id).get();
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<UserClass> userOptional = userClassRepository.findById(userId);
        
        if(!userOptional.isPresent()){
            throw new IllegalStateException("User obect not present");
        }
        UserClass user = userOptional.get();
        Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getUserClassId(), Department.class);
        vo.setUserClass(user);
        vo.setDepartment(department);
        return vo;
    }

    public UserClass findUserByUserClassId(Long id) {
        return userClassRepository.findById(id).get();
    }



}
