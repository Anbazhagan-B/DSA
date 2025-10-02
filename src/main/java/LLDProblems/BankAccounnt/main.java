package LLDProblems.BankAccounnt;

import java.util.UUID;

public class main {
    public static void main(String[] args)
    {
        Account acc = new Account(UUID.randomUUID().toString(), AccountType.SALARY, 3.0,"Anbu", "Bank1");
        System.out.println(acc.toString());

        Account acc1 = new Account(UUID.randomUUID().toString(), AccountType.SALARY, 5.0,"Ajay", "Bank2");
        System.out.println(acc1.toString());

        acc.deposit(500);
        System.out.println(acc.getBalance());
       // acc.withdraw(2000);

        transferAmount(acc, acc1, 500);

    }

    static void transferAmount(Account account, Account account1, double amount)
    {
        if(account.getBalance() < amount)
        {
            throw new IllegalStateException("Amount is not enough on Accounnt :- " + account.accountNumber);
        }

        account.withdraw(amount);

        account1.deposit(amount);

        System.out.printf("Balance amount on debited account %s\n", account.getBalance());
        System.out.printf("Balance amount on Credited account %s\n", account1.getBalance());
    }
}
