package com.searhiy.rest;

import com.searhiy.rest.model.Account;
import com.searhiy.rest.repository.InMemoryBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by serhii on 01.12.14.
 */
@Component
public class Fixtures {

    @Autowired
    private InMemoryBankRepository inMemoryBankRepository;

    @PostConstruct
    private void init(){

        Account account1 = new Account();
        account1.setName("Mike");
        inMemoryBankRepository.createAccount(account1);
        Account account2 = new Account();
        account2.setName("Trevor");
        inMemoryBankRepository.createAccount(account2);
        // create here default accounts and credit cards
    }
}
