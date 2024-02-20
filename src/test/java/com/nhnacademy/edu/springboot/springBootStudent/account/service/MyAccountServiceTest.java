package com.nhnacademy.edu.springboot.springBootStudent.account.service;

import com.nhnacademy.edu.springboot.springBootStudent.student.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyAccountServiceTest {

    @Autowired
    StudentService studentService;
    @Test
    void getAccount() {

        Assertions.assertThat(studentService.getStudents()).hasSize(1);
    }
}