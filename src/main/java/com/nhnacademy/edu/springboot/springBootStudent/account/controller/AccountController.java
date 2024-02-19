package com.nhnacademy.edu.springboot.springBootStudent.account.controller;

import com.nhnacademy.edu.springboot.springBootStudent.account.domain.Account;
import com.nhnacademy.edu.springboot.springBootStudent.account.service.AccountService;
import com.nhnacademy.edu.springboot.springBootStudent.student.controller.ResultResponse;
import com.nhnacademy.edu.springboot.springBootStudent.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") Long id){
        return accountService.getAccount(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createStudent(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @DeleteMapping("/{id}")
    public ResultResponse deleteStudent(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return new ResultResponse("OK");
    }
}
