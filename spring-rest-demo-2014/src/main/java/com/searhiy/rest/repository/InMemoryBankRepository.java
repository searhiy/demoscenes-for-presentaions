package com.searhiy.rest.repository;

import com.searhiy.rest.model.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by serhii on 01.12.14.
 */
@Component
public class InMemoryBankRepository implements AccountRepository, CreditCardRepository{

    private final Map<Long, Account> accounts = new HashMap<>();

    private final AtomicLong accountIdGenerator = new AtomicLong();
    private final AtomicLong creditCardIdGenerator = new AtomicLong();

    private final Object monitor = new Object();

    @Override
    public Account createAccount(Account account) {
        synchronized (this.monitor) {
            Long id = this.accountIdGenerator.getAndIncrement();
            account.setId(id);
            this.accounts.put(id, account);
            return account;
        }
    }

    @Override
    public Account retrieveAccount(Long id) throws AccountDoesNotExist {
        synchronized (this.monitor) {
            if (!this.accounts.containsKey(id)) {
                throw new AccountDoesNotExist(id);
            }
            return this.accounts.get(id);
        }
    }

    @Override
    public Collection<Account> listAccounts() {
        synchronized (this.monitor) {
            return accounts.values();
        }
    }

    @Override
    public void deleteAccount(Long id) throws AccountDoesNotExist {
        synchronized (this.monitor) {
            if (!this.accounts.containsKey(id)) {
                throw new AccountDoesNotExist(id);
            }
            this.accounts.remove(id);
        }
    }

    @Override
    public CreditCard createCreditCard(Long accountId) throws AccountDoesNotExist {
        synchronized (this.monitor){
            CreditCard creditCard = new CreditCard();
            creditCard.setPIN(1111);
            creditCard.setCardStatus(CardStatus.ACTIVE);
            creditCard.setCardNumber(this.creditCardIdGenerator.getAndIncrement());

            Account account = retrieveAccount(accountId);
            account.getCreditCards().add(creditCard);

            return creditCard;
        }
    }

    @Override
    public CreditCard retrieveCreditCard(Long accountId, Long cardNumber) throws CreditCardDoesNotExist, AccountDoesNotExist {
        synchronized (this.monitor){
            Account account = retrieveAccount(accountId);
            for (CreditCard creditCard : account.getCreditCards()) {
                if (cardNumber.equals(creditCard.getCardNumber())){
                    return creditCard;
                }
            }
        }
        throw new CreditCardDoesNotExist(cardNumber);
    }

    @Override
    public Collection<CreditCard> listCreditCards(Long account_id) throws AccountDoesNotExist {
        synchronized (this.monitor){
            Account account = retrieveAccount(account_id);
            return account.getCreditCards();
        }
    }

    @Override
    public void lockCreditCard(Long accountId, Long cardNumber) throws CreditCardDoesNotExist, AccountDoesNotExist {
        synchronized (this.monitor){
            Account account = retrieveAccount(accountId);
            for (CreditCard creditCard : account.getCreditCards()) {
                if (cardNumber.equals(creditCard.getCardNumber())){
                    creditCard.setCardStatus(CardStatus.LOCKED);
                }
            }
        }
    }
}
