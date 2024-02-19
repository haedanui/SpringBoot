package com.nhnacademy.edu.springboot.springBootStudent.student.repository;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void testStudentRepository() {
        Student zbum = new Student(1L, "zbum", 100);
        studentRepository.save(zbum);

        Optional<Student> actual =  studentRepository.findById(1L);
        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(zbum);
    }
}