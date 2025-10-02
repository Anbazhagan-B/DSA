package com.DsaProject.LLD.LibraryManagementLLD;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    String id;
    BookCopy bookCopy;
    Member member;
    LocalDate borrowDate;
    LocalDate dueDate;
    boolean isActive;
    int MAX_BORROW_DAYS = 14;

    public Loan(BookCopy bookCopy, Member member)
    {
        this.id = UUID.randomUUID().toString();
        this.bookCopy = bookCopy;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.dueDate = this.borrowDate.plusDays(MAX_BORROW_DAYS);
    }

    public void closeLoan()
    {
        bookCopy.markReturned();
        member.removeLoan(this);
        isActive = false;
    }

    public String getId()
    {
        return this.id;
    }
}
