package com.searhiy.rest;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by serhii on 01.12.14.
 */
@Component
public class Fixtures {

    @PostConstruct
    private void init(){
        // create here default accounts and credit cards
    }
}
