package com.nhnacademy.edu.springboot.springBootStudent.account.repository;

import com.nhnacademy.edu.springboot.springBootStudent.account.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //mysql 쓸때
class AccountRepositorySliceTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void testFindById() throws Exception{

        long id = 25L;
        Account notMyAccount = new Account(id, "seungjin", Integer.MAX_VALUE);
        entityManager.merge(notMyAccount);

        Optional<Account> actual = accountRepository.findById(id);

        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(notMyAccount);
    }

}