package com.example.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.VO.ResponseTemplateVO;
import com.example.user_service.entities.UserClass;
import com.example.user_service.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserClass saveUserClass(@RequestBody UserClass User){
        log.info("Inside save User method of User controller");
        return userService.saveUser(User);
    }

    public UserClass findUserByUserId(@PathVariable Long id){
        log.info("Inside get User by method User controller");
        return userService.findUserByUserClassId(id);
    }
    
    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long userId){
        log.info("Inside get UserWthDepartment by method User controller");
        return userService.getUserWithDepartment(userId);
    }

}
