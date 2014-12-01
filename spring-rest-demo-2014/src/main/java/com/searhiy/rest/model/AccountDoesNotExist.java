package com.searhiy.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by serhii on 01.12.14.
 */
// TODO 2: NOT_FOUND Status Code
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountDoesNotExist extends Exception {

    public AccountDoesNotExist (Long id) {
        super(String.format("Account %d does not exist", id));
    }
}
