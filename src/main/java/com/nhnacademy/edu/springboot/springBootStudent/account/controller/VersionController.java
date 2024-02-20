package com.nhnacademy.edu.springboot.springBootStudent.account.controller;

import com.nhnacademy.edu.springboot.springBootStudent.account.config.AccountProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.SystemProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/system/version")
@RequiredArgsConstructor
public class VersionController {

    private final AccountProperties accountProperties;

//    @GetMapping
//    public Version getVersion(){
//        return new Version(accountProperties.getVersion());
//    }

    @GetMapping
    public Map<String, String> getVersion(){
        return Map.of("version", accountProperties.getVersion());
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class Version{
        private final String version;
    }
}
