package com.nhnacademy.edu.springboot.springBootStudent.account.controller;

import com.nhnacademy.edu.springboot.springBootStudent.student.management.MyHealthIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/fail")
public class MyHealthController {
    private final MyHealthIndicator myHealthIndicator;

    @Autowired
    public MyHealthController(MyHealthIndicator myHealthIndicator) {
        this.myHealthIndicator = myHealthIndicator;
    }

    @PostMapping
    public void setFail(){
        myHealthIndicator.setUnhealthy();
    }
}
