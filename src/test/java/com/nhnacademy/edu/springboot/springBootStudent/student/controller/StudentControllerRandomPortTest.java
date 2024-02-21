package com.nhnacademy.edu.springboot.springBootStudent.student.controller;

import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerRandomPortTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void testGetStudents() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<List<Student>> actual = restTemplate.exchange("/students",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Student>>() {
                });
        assertThat(actual.getBody())
                .contains(new Student(1L, "zbum", 100));
    }

}