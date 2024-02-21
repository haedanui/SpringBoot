package com.nhnacademy.edu.springboot.springBootStudent.student.service;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import com.nhnacademy.edu.springboot.springBootStudent.student.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class NhnStudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    void testGetStudent() {
        List<Student> actual = studentService.getStudents();

        Assertions.assertThat(actual).hasSize(1);
    }
}