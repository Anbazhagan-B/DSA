package com.DsaProject.LLD.LibraryManagementLLD;


import java.util.*;

public class Member {
    String id;
    String name;
    String contactInfo;
    List<Loan> loans;
    int MAX_BOOKS = 5;

    public Member(String name, String contactInfo)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = contactInfo;
        this.loans = Collections.synchronizedList( new ArrayList<>());
    }

    public synchronized boolean canBorrow()
    {
       return this.loans.size() < MAX_BOOKS;
    }

    public synchronized void addLoan(Loan loan)
    {
        loans.add(loan);
    }

    public synchronized void removeLoan(Loan loan)
    {
        loans.remove(loan);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
