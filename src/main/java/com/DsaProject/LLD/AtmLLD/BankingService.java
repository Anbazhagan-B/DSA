package com.DsaProject.LLD.AtmLLD;

import java.util.*;

public class BankingService {
    Map<String, Account> accounts;
    Map<String, Card> cards;

    public BankingService()
    {
        this.accounts = new HashMap<>();
        this.cards = new HashMap<>();
    }

    public void createAccount(String accountNumber, double balance)
    {
        accounts.put(accountNumber, new Account(accountNumber, balance));
    }

    public void processTransaction(Transaction transaction)
    {
        transaction.execute();
    }

    public Account getAccount(String accountNumber)
    {
        if(!accounts.containsKey(accountNumber))
            throw new RuntimeException("Account does exists");
        return accounts.get(accountNumber);
    }

    public boolean authenticate(String cardNumber, String cardPin)
    {
        Card card = cards.get(cardNumber);

        return card != null && card.pin.equals(cardPin);
    }

    public void linkCardToAccount(String accountNumber, String cardNumber, String pin)
    {
        if(accounts.containsValue(accountNumber))
        {
            cards.put(cardNumber, new Card(cardNumber, pin));
        }
    }

    public Card getCard(String cardNumber)
    {
        return this.cards.get(cardNumber);
    }
}
