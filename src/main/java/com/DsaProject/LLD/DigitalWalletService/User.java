package com.DsaProject.LLD.DigitalWalletService;

import java.util.ArrayList;
import java.util.List;

public class User {
    String id;
    String name;
    String password;
    String email;
    List<Account> accounts;

    public User(String id, String name, String password, String email)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    public void addAccounts(Account account)
    {
        accounts.add(account);
    }

    public void removeAccount(Account account)
    {
        accounts.remove(account);
    }

    public String getId() {
        return id;
    }
}
