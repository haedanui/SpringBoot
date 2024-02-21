package com.nhnacademy.edu.springboot.springBootStudent.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void testGetStudents() throws Exception{
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo("zbum")));
    }

    @Test
    @Order(2)
    void testGetStudent() throws Exception{
        mockMvc.perform(get("/students/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("zbum")));
    }

    @Test
    @Order(3)
    void testCreateStudent() throws Exception{
        Student input = new Student(998L, "haedanui", 100);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/students")
                .content(objectMapper.writeValueAsString(input))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("haedanui")))
                .andExpect(jsonPath("$.score", equalTo(100)));
    }

    @Test
    @Order(4)
    void testDeleteStudent() throws Exception{
        mockMvc.perform(delete("/students/{id}", 998L))
                .andExpect(status().isOk());
    }

}