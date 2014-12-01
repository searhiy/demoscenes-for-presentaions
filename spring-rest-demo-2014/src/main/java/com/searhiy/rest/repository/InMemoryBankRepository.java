package com.searhiy.rest.repository;

import com.searhiy.rest.model.Account;
import com.searhiy.rest.model.AccountDoesNotExist;
import com.searhiy.rest.model.CreditCard;
import com.searhiy.rest.model.CreditCardDoesNotExist;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serhii on 01.12.14.
 */
@Component
public class InMemoryBankRepository implements AccountRepository, CreditCardRepository{

    private final Map<Long, Account> accounts = new HashMap<>();

    private final Object monitor = new Object();

    @Override
    public Account createAccount() {
        return null;
    }

    @Override
    public Account retrieveAccount(Long id) throws AccountDoesNotExist {
        return null;
    }

    @Override
    public Account deleteAccount(Long id) throws AccountDoesNotExist {
        return null;
    }

    @Override
    public CreditCard createCreditCard(Long accountId) {
        return null;
    }

    @Override
    public CreditCard retrieveCreditCard(Long id) throws CreditCardDoesNotExist {
        return null;
    }

    @Override
    public CreditCard deleteCreditCard(Long id) throws CreditCardDoesNotExist {
        return null;
    }
}
