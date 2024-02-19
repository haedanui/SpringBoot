package com.nhnacademy.edu.springboot.springBootStudent.account.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Account {
    String number;
    Integer balance;

    public Account(String number, Integer balance) {
        this.number = number;
        this.balance = balance;
    }
}
