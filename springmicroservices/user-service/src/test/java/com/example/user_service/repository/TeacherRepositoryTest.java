package com.example.user_service.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user_service.entities.Course;
import com.example.user_service.entities.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                            .courseName(null)
                            .build();
                        
        Teacher teacher = Teacher.builder()
                            .firstName("Sanjeev")
                            .lastName("verma")
                            .courses(null)
                            .build();
    }
}
