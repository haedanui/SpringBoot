package com.nhnacademy.edu.springboot.springBootStudent.account.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    Long id;
    String number;
    Integer balance;

    public Account() {
    }

    public Account(Long id, String number, Integer balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }
}
