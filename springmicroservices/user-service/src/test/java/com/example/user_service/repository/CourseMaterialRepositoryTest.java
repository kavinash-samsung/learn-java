package com.example.user_service.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user_service.entities.Course;
import com.example.user_service.entities.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                        .courseName("DSA").credit(6)
                        .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
            .course(course).url("http://dsacourse.com")
            .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourses(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
    }
}
