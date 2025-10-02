package com.DsaProject.LLD.LibraryManagementLLD;

import com.DsaProject.LLD.AirlineManagementSystemLLD.Booking.Booking;

public class Book {
    String isbn;
    String title;
    String author;

    public Book(String isbn, String title, String author)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn()
    {
        return this.isbn;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }
}
