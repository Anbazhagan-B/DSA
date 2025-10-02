package com.DsaProject.LLD.AtmLLD;

public class WithdrawTransaction extends Transaction{

    public WithdrawTransaction(String transactionId, Account account, double amount)
    {
        super(transactionId, account, amount);
    }
    @Override
    public void execute()
    {
        this.account.debit(amount);
    }
}
