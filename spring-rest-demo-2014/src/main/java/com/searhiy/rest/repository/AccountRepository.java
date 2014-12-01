package com.searhiy.rest.repository;

import com.searhiy.rest.model.Account;
import com.searhiy.rest.model.AccountDoesNotExist;

/**
 * Created by serhii on 01.12.14.
 */
public interface AccountRepository {

    Account createAccount();

    Account retrieveAccount(Long id) throws AccountDoesNotExist;

    Account deleteAccount(Long id) throws AccountDoesNotExist;

}
