package com.searhiy.rest.model;

import lombok.Data;

import java.util.List;

/**
 * Created by serhii on 01.12.14.
 */
public @Data class Account {

    private Long id;
    private String name;
    private List<CreditCard> creditCards;
}
