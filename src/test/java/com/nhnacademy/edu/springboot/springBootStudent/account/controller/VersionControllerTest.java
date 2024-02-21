package com.nhnacademy.edu.springboot.springBootStudent.account.controller;

import com.nhnacademy.edu.springboot.springBootStudent.account.config.AccountProperties;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VersionController.class)
class VersionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountProperties accountProperties;

    @Test
    void testGetVersion() throws Exception{
        String version = "10.0.0";
        given(accountProperties.getVersion()).willReturn(version);

        mockMvc.perform(get("/system/version"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.version", Matchers.equalTo(version)));
    }

}