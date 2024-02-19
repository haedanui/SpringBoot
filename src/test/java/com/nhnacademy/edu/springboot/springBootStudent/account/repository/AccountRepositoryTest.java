package com.nhnacademy.edu.springboot.springBootStudent.account.repository;

import com.nhnacademy.edu.springboot.springBootStudent.account.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    void testStudentRepository(){
        Account account1 = new Account(1L, "RyuSeungJin", Integer.MAX_VALUE);
        accountRepository.save(account1);

        Optional<Account> actual = accountRepository.findById(1L);
        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(account1);
    }

}