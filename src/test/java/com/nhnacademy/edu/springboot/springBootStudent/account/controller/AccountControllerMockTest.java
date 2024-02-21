package com.nhnacademy.edu.springboot.springBootStudent.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.springBootStudent.account.domain.Account;
import com.nhnacademy.edu.springboot.springBootStudent.account.repository.AccountRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerMockTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountRepository accountRepository;

    @Test
    @Order(1)
    void testGetAccounts() throws Exception {
        given(accountRepository.findAll())
                .willReturn(List.of(new Account(1L, "RyuSeungJin", 5)));

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].number", equalTo("RyuSeungJin")));
    }

    @Test
    @Order(2)
    void testGetAccount() throws Exception {
        given(accountRepository.findById(1L))
                .willReturn(Optional.of(new Account(1L, "RyuSeungJin", 2147483647)));

        mockMvc.perform(get("/accounts/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", equalTo("RyuSeungJin")));
    }

    @Test
    @Order(3)
    void testCreateAccount() throws Exception {
        Account input = new Account(1121L, "김근육", 1000000000);
        given(accountRepository.existsById(1121L))
                .willReturn(false);
        given(accountRepository.save(any())).willReturn(input);

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(
                        post("/accounts")
                                .content(objectMapper.writeValueAsString(input))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", equalTo("김근육")))
                .andExpect(jsonPath("$.balance", equalTo(1000000000)));
    }

    @Test
    @Order(4)
    void deleteAccount() throws Exception {
        mockMvc.perform(delete("/accounts/{id}", 998L))
                .andExpect(status().isOk());
    }
}