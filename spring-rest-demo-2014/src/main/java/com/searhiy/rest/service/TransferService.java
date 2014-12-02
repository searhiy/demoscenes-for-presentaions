package com.searhiy.rest.service;

import com.searhiy.rest.model.CreditCard;
import com.searhiy.rest.model.CreditCardDoesNotExist;
import com.searhiy.rest.model.Transaction;
import com.searhiy.rest.repository.InMemoryBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by serhii on 01.12.14.
 */
@Service
public class TransferService {

    private final Object monitor = new Object();

    @Autowired
    private InMemoryBankRepository inMemoryBankRepository;

    public void transfer(Transaction transaction) throws CreditCardDoesNotExist {
        synchronized (this.monitor){
            CreditCard toCreditCard = inMemoryBankRepository.retrieveCreditCard(transaction.getToCreditCard());
            double amount = transaction.getAmount();
            if (transaction.getFromCreditCard()!=null) {
                CreditCard fromCreditCard = inMemoryBankRepository.retrieveCreditCard(transaction.getFromCreditCard());
                if (fromCreditCard.getRemnant() - amount >= 0){
                    fromCreditCard.setRemnant(fromCreditCard.getRemnant() - amount);
                    toCreditCard.setRemnant(toCreditCard.getRemnant() + amount);
                }
            } else {
                toCreditCard.setRemnant(toCreditCard.getRemnant() + amount);
            }
        }
    }

}
