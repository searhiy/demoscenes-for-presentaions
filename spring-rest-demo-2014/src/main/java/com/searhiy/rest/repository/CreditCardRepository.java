package com.searhiy.rest.repository;

import com.searhiy.rest.model.CreditCard;
import com.searhiy.rest.model.CreditCardDoesNotExist;

/**
 * Created by serhii on 01.12.14.
 */
public interface CreditCardRepository {

    CreditCard createCreditCard(Long accountId);

    CreditCard retrieveCreditCard(Long id) throws CreditCardDoesNotExist;

    CreditCard deleteCreditCard(Long id) throws CreditCardDoesNotExist;
}
