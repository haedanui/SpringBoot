package com.nhnacademy.edu.springboot.springBootStudent.student.service;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import com.nhnacademy.edu.springboot.springBootStudent.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhnStudentService implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public NhnStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
}
