package com.searhiy.rest.repository;

import com.searhiy.rest.model.AccountDoesNotExist;
import com.searhiy.rest.model.CreditCard;
import com.searhiy.rest.model.CreditCardDoesNotExist;

import java.util.Collection;

/**
 * Created by serhii on 01.12.14.
 */
public interface CreditCardRepository {

    CreditCard createCreditCard(Long accountId) throws AccountDoesNotExist;

    CreditCard retrieveCreditCard(Long accountId, Long cardNumber) throws AccountDoesNotExist, CreditCardDoesNotExist;

    CreditCard retrieveCreditCard(Long cardNumber) throws CreditCardDoesNotExist;

    Collection<CreditCard> listCreditCards(Long accountId) throws AccountDoesNotExist;

    CreditCard changeStatusOfCreditCard(Long accountId, Long cardNumber) throws CreditCardDoesNotExist, AccountDoesNotExist;
}
