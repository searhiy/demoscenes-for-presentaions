package com.searhiy.rest;

import com.searhiy.rest.model.Account;
import com.searhiy.rest.model.AccountDoesNotExist;
import com.searhiy.rest.model.CreditCardDoesNotExist;
import com.searhiy.rest.model.Transaction;
import com.searhiy.rest.repository.InMemoryBankRepository;
import com.searhiy.rest.service.TransferService;
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
    @Autowired
    private TransferService transferService;

    @PostConstruct
    private void init() throws AccountDoesNotExist, CreditCardDoesNotExist {

        Account account1 = new Account();
        account1.setName("Mike");
        inMemoryBankRepository.createAccount(account1);
        inMemoryBankRepository.createCreditCard(new Long(0));

        Transaction transaction1 = new Transaction();
        transaction1.setToCreditCard(new Long(0));
        transaction1.setAmount(100);
        transferService.transfer(transaction1);

        Account account2 = new Account();
        account2.setName("Trevor");
        inMemoryBankRepository.createAccount(account2);
        inMemoryBankRepository.createCreditCard(new Long(1));

        Transaction transaction2 = new Transaction();
        transaction2.setToCreditCard(new Long(1));
        transaction2.setAmount(40);
        transferService.transfer(transaction2);
    }
}
