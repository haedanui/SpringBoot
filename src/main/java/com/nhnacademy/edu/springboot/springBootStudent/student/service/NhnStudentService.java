package com.nhnacademy.edu.springboot.springBootStudent.student.service;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import com.nhnacademy.edu.springboot.springBootStudent.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhnStudentService implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public NhnStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);

    }

    @Override
    public Student createStudent(Student student) {
        if(studentRepository.existsById(student.getId())){
            throw new IllegalStateException("id : " + student.getId() + "값이 중복됩니다.");
        }
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("id : " + id + "값을 찾을 수 없습니다.");
        }
    }
}
