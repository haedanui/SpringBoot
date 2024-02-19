package com.nhnacademy.edu.springboot.springBootStudent.student.repository;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> fineAll();
}
