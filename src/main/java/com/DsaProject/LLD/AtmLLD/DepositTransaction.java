package com.DsaProject.LLD.AtmLLD;

public class DepositTransaction extends Transaction{

    public DepositTransaction(String transactionId, Account account, double amount)
    {
        super(transactionId, account, amount);
    }

    public void execute()
    {
        this.account.credit(amount);
    }
}
