package com.nhnacademy.edu.springboot.springBootStudent.student.repository;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
