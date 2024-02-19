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
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account createAccount(Account account) {
        if(accountRepository.existsById(account.getId())){
            throw new IllegalStateException("id : " + account.getId() + "값이 중복됩니다.");
        }
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("id : " + id + "값을 찾을 수 없습니다.");
        }
    }
}
