package com.nhnacademy.edu.springboot.springBootStudent.account.repository;

import com.nhnacademy.edu.springboot.springBootStudent.account.domain.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
}
