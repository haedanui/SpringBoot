package com.nhnacademy.edu.springboot.springBootStudent.student.controller;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentWebController {

    @GetMapping("/web/students/{id}")
    public String getStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", new Student(1L, "seungJin", 100));
        return "student";
    }
}
