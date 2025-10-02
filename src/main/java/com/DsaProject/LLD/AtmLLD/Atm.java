package com.DsaProject.LLD.AtmLLD;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class Atm {
    BankingService bankingService;
    CashDispenser cashDispenser;
    AtomicLong transactionNumber;

    public Atm(BankingService bankingService, CashDispenser cashDispenser)
    {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public void authenticateUser(Card card)
    {
        boolean isAuthenticated = bankingService.authenticate(card.cardNumber, card.pin);

        if (isAuthenticated) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    public double checkBalance(String accountNumber)
    {
        Account account = bankingService.getAccount(accountNumber);
        return account.getBalance();
    }

    public void withdraw(String accountNumber, double amount)
    {
        Account account = bankingService.getAccount(accountNumber);

        if(account != null && account.getBalance() < amount)
        {
            throw new RuntimeException("Insufficient fund in bank account");
        }
        Transaction transaction = new WithdrawTransaction("1", account, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash(amount);
    }

    public void deposit(String accountNumber, double amount)
    {
        Account account = bankingService.getAccount(accountNumber);
        Transaction transaction = new DepositTransaction("1", account, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash(amount);
    }

    String getTransactionId()
    {
        long transaction = transactionNumber.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN" + timestamp + transaction;
    }

}
