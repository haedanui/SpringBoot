package com.nhnacademy.edu.springboot.springBootStudent.student.service;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(Long id);

    Student createStudent(Student student);

    void deleteStudent(Long id);
}
