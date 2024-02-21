package com.nhnacademy.edu.springboot.springBootStudent.student.repository;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositorySliceTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    StudentRepository studentRepository;


    @Test
    void testFindById() throws Exception{
        long studentId = 10L;
        Student goodStudent = new Student(studentId, "good", 100);
        entityManager.merge(goodStudent);

        Optional<Student> actual = studentRepository.findById(studentId);

        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(goodStudent);

    }
}