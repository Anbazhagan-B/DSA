package com.DsaProject.LLD.LibraryManagementLLD;

import java.util.UUID;

public class BookCopy {
    String id;
    Book book;
    boolean isAvailable;

    public BookCopy(Book book)
    {
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.isAvailable = true;
    }

    public void markIssued()
    {
        if(!isAvailable) throw new RuntimeException("Already Issued");
        this.isAvailable = false;
    }

    public synchronized void markReturned()
    {
        this.isAvailable = true;
    }

    public Book getBook()
    {
        return this.book;
    }

    public String getId()
    {
        return this.id;
    }
}
