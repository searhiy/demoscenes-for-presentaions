package com.searhiy.rest.service;

import com.searhiy.rest.repository.InMemoryBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by serhii on 01.12.14.
 */
@Service
public class TransactionService {

    @Autowired
    private InMemoryBankRepository inMemoryBankRepository;
}
