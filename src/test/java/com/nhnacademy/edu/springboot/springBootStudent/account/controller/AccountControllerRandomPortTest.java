package com.nhnacademy.edu.springboot.springBootStudent.account.controller;

import com.nhnacademy.edu.springboot.springBootStudent.account.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerRandomPortTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void testGetAccounts() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<List<Account>> actual = restTemplate.exchange("/accounts",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Account>>() {
                });
        assertThat(actual.getBody())
                .contains(new Account(998L, "haedanui", 19721121));

    }

}