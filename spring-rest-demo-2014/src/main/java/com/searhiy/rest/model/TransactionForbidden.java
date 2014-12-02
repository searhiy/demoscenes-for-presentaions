package com.searhiy.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by serhii on 02.12.14.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TransactionForbidden extends Exception {

    public TransactionForbidden(String message){
        super(message);
    }
}
