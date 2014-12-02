package com.searhiy.rest.repository;

import com.searhiy.rest.model.Account;
import com.searhiy.rest.model.AccountDoesNotExist;

import java.util.Collection;

/**
 * Created by serhii on 01.12.14.
 */
public interface AccountRepository {

    Account createAccount(Account account);

    Account retrieveAccount(Long id) throws AccountDoesNotExist;

    Collection<Account> listAccounts();

    // With JPA you can you Pageable object for retrieving data by parts
    // List<Account> findAll(Pageable pageable);

    void deleteAccount(Long id) throws AccountDoesNotExist;

}
