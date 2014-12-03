package com.searhiy.rest.web;

import com.searhiy.rest.model.Account;
import com.searhiy.rest.model.AccountDoesNotExist;
import com.searhiy.rest.model.CreditCard;
import com.searhiy.rest.model.CreditCardDoesNotExist;
import com.searhiy.rest.repository.InMemoryBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by serhii on 27.11.14.
 */
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private InMemoryBankRepository inMemoryBankRepository;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Account createClient(@RequestBody Account account) {
        return inMemoryBankRepository.createAccount(account);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public Collection<Account> listClients() {
        return inMemoryBankRepository.listAccounts();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{account_id}")
    @ResponseStatus(HttpStatus.OK)
    public Account gettingClient(@PathVariable Long account_id) throws AccountDoesNotExist {
        return inMemoryBankRepository.retrieveAccount(account_id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{account_id}")
    @ResponseStatus(HttpStatus.OK)
    public void delitingClient(@PathVariable Long account_id) throws AccountDoesNotExist {
        inMemoryBankRepository.deleteAccount(account_id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/{account_id}/creditcards")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard createCreditCard(@PathVariable Long account_id) throws AccountDoesNotExist {
        return inMemoryBankRepository.createCreditCard(account_id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{account_id}/creditcards")
    public Collection<CreditCard> listCreditCards(@PathVariable Long account_id) throws AccountDoesNotExist {
        return inMemoryBankRepository.listCreditCards(account_id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{account_id}/creditcards/{credit_card_id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCard gettingCreditCard(@PathVariable Long account_id, @PathVariable Long credit_card_id) throws AccountDoesNotExist, CreditCardDoesNotExist {
        return inMemoryBankRepository.retrieveCreditCard(account_id, credit_card_id);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{account_id}/creditcards/{credit_card_id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCard lockingCreditCard(@PathVariable Long account_id, @PathVariable Long credit_card_id) throws AccountDoesNotExist, CreditCardDoesNotExist {
        return inMemoryBankRepository.changeStatusOfCreditCard(account_id, credit_card_id);
    }
}
