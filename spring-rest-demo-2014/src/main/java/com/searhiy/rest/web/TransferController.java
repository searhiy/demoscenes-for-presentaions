package com.searhiy.rest.web;

import com.searhiy.rest.model.CreditCardDoesNotExist;
import com.searhiy.rest.model.Transaction;
import com.searhiy.rest.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by serhii on 01.12.14.
 */
@RestController
@RequestMapping(value = "/transactions")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createClient(@RequestBody Transaction transaction) throws CreditCardDoesNotExist {
        transferService.transfer(transaction);
    }

}
