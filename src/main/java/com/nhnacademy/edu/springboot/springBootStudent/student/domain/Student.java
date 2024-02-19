package com.nhnacademy.edu.springboot.springBootStudent.student.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Students")
public class Student {

    @Id
    private Long id;
    private String name;
    private Integer score;
    public Student() {
    }

    public Student(Long id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
