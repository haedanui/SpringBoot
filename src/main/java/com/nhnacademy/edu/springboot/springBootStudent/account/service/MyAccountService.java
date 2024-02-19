package com.nhnacademy.edu.springboot.springBootStudent.account.service;

import com.nhnacademy.edu.springboot.springBootStudent.account.domain.Account;
import com.nhnacademy.edu.springboot.springBootStudent.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAccountService implements AccountService{
    AccountRepository accountRepository;

    @Autowired
    public MyAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }
}
