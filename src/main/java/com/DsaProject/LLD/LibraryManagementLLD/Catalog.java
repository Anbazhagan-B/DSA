package com.DsaProject.LLD.LibraryManagementLLD;

import java.util.*;

public class Catalog {

    Map<String, List<BookCopy>> booksByAuthor = new HashMap<>();
    Map<String, List<BookCopy>> booksByIsbn = new HashMap<>();
    Map<String, List<BookCopy>> booksByTitle = new HashMap<>();

    public synchronized void add(BookCopy bookCopy)
    {
        Book book = bookCopy.getBook();
        this.booksByAuthor.computeIfAbsent(book.getAuthor(), k -> new ArrayList<>()).add(bookCopy);
        this.booksByIsbn.computeIfAbsent(book.getIsbn(), k -> new ArrayList<>()).add(bookCopy);
        this.booksByTitle.computeIfAbsent(book.getTitle(), k -> new ArrayList<>()).add(bookCopy);
    }

    public synchronized List<BookCopy> getBookCopiesByTitle(String title)
    {
        return booksByTitle.getOrDefault(title, List.of());
    }

    public synchronized List<Book> searchBookByTitle(String title)
    {
        return booksByTitle.getOrDefault(title, List.of()).stream().map(BookCopy::getBook).toList();
    }

    public synchronized List<Book> searchBookByIsbn(String isbn)
    {
        return booksByIsbn.getOrDefault(isbn, List.of()).stream().map(BookCopy::getBook).toList();
    }

    public synchronized List<Book> searchBookByAuthor(String author)
    {
        return booksByAuthor.getOrDefault(author, List.of()).stream().map(BookCopy::getBook).toList();
    }
}
