package com.example.springboot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.springboot.entity.Department;
import com.example.springboot.service.DepartmentService;

@WebMvcTest
public class DepartmentControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        department = Department.builder()
                    .departmentAddress("Delhi")
                    .departmentCode("ME-04")
                    .departmentName("Mech")
                    .departmentId(1L)
                    .build();
    }

    @Test
    void saveDepartment() throws Exception{
        Department inputDepartment = Department.builder()
        .departmentAddress("Delhi")
        .departmentCode("ME-04")
        .departmentName("Mech")
        .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
        .content("{\n" + //
                        "    \"departmentName\":\"Mech\", \n" + //
                        "    \"departmentCode\":\"ME-04\",\n" + //
                        "    \"departmentAddress\":\"Delhi\"\n" + //
                        "}"))
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
