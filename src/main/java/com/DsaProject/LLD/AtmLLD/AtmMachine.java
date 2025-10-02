package com.DsaProject.LLD.AtmLLD;

public class AtmMachine {
    public static void main(String[] args)
    {
        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser(10000);
        Atm atm = new Atm(bankingService, cashDispenser);


        bankingService.createAccount("1234567890", 1000.0);
        bankingService.createAccount("9876543210", 500.0);

        // Perform ATM operations
        Card card = new Card("1234567890", "1234");
        atm.authenticateUser(card);

        double balance = atm.checkBalance("1234567890");
        System.out.println("Account balance: " + balance);

        atm.withdraw("1234567890", 500.0);
        atm.deposit("9876543210", 200.0);

        balance = atm.checkBalance("1234567890");
        System.out.println("Updated account balance: " + balance);
    }

}
