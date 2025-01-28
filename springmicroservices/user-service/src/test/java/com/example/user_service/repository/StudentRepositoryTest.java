package com.example.user_service.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user_service.entities.Gurdian;
import com.example.user_service.entities.Student;

@SpringBootTest
public class StudentRepositoryTest {
    
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                            .emailId("Avinash1@gmail.com")
                            .firstName("Avinash")
                            .lastName("Kumar")
                            .build();
                studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGurdian(){
        Gurdian gurdian = Gurdian.builder()
                            .email("ankur@gmail.com")
                            .name("Ankur")
                            .mobile("99990")
                            .build();
        Student student = Student.builder()
                            .emailId("Avinash3@gmail.com")
                            .firstName("Avinash")
                            .lastName("Kumar")
                            .gurdian(gurdian)
                            .build();
                studentRepository.save(student);

    }
}
