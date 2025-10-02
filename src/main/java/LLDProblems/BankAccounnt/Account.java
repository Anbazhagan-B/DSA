package LLDProblems.BankAccounnt;

public class Account {
    String accountNumber;
    AccountType accountType;
    double amount;
    String accountHolderName;
    String bankCode;

    // deposit
    //withdraw
    // checkbalance

    public Account(String accountNumber, AccountType accountType, double amount, String accountHolderName, String bankCode)
    {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
        this.accountHolderName = accountHolderName;
        this.bankCode = bankCode;
    }

    public void deposit(double amount)
    {
        this.amount += amount;
    }

    public boolean withdraw(double amount)
    {
        if(amount > this.amount)
        {
            throw new RuntimeException("Balance amount is not enough");
        }

        this.amount -= amount;
        return true;
    }

    public double getBalance()
    {
        return this.amount;
    }

}
