package com.DsaProject.LLD.DigitalWalletService;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;

public class DigitalWallet {

    static DigitalWallet instance;
    Map<String, User> users;
    Map<String, Account> accounts;
    Map<String, PaymentMethod> paymentMethods;


    private DigitalWallet()
    {
        this.users = new HashMap<>();
        this.accounts = new HashMap<>();
        this.paymentMethods = new HashMap<>();
    }

    public static DigitalWallet getInstance() {
        if(instance == null)
        {
            instance = new DigitalWallet();
        }

        return instance;
    }

    public void createUser(User user)
    {
        this.users.put(user.getId(), user);
    }

    public User getUser(String userId)
    {
        return this.users.get(userId);
    }

    public void createAccount(Account account)
    {
        this.accounts.put(account.getId(), account);
    }

    public Account getAccount(String accountId)
    {
        return this.accounts.get(accountId);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod)
    {
        paymentMethods.put(paymentMethod.getId(), paymentMethod);
    }

    public PaymentMethod getPaymentMethod(String paymentMethodId)
    {
        return paymentMethods.get(paymentMethodId);
    }

    public synchronized void transferFunds(Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency)
    {
        if(sourceAccount.getCurrency() != currency)
        {
            amount = CurrencyConverter.convert(amount, currency, sourceAccount.getCurrency());
        }

        sourceAccount.withdraw(amount);

        if(destinationAccount.getCurrency() != sourceAccount.getCurrency())
        {
            amount = CurrencyConverter.convert(amount, sourceAccount.getCurrency(), destinationAccount.getCurrency());
       }
        destinationAccount.deposit(amount);

        String transactionId = getTransactionId();
        Transaction transaction = new Transaction(transactionId, sourceAccount, destinationAccount,amount, currency);
        sourceAccount.addTransaction(transaction);
        destinationAccount.addTransaction(transaction);
    }

    public List<Transaction> getTransactionHistory(Account account)
    {
        return account.getTransactions();
    }

    String getTransactionId()
    {
        return  "TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
