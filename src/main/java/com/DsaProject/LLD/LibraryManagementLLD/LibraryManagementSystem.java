package com.DsaProject.LLD.LibraryManagementLLD;

import java.util.*;

public class LibraryManagementSystem {
    static LibraryManagementSystem instance;
    Catalog catalog;
    Map<String, Member> members;
    Map<String, Loan> loans;

    public static LibraryManagementSystem getInstance()
    {
       if(instance == null)
           instance = new LibraryManagementSystem();
       return instance;
    }

    public LibraryManagementSystem()
    {
        this.loans = new HashMap<>();
        this.members = new HashMap<>();
        this.catalog = new Catalog();
    }

    public void addBook(Book book)
    {
        BookCopy bookCopy = new BookCopy(book);
        catalog.add(bookCopy);
    }

    public Member registerMember(String name, String contactInfo)
    {
        Member member = new Member(name, contactInfo);
        members.put(member.getId(), member);
        return member;
    }

    public synchronized Loan borrowBook(String memberId, String title)
    {
        Member member = members.get(memberId);
        if(member == null || !member.canBorrow()) throw new RuntimeException("Borrow Book");

        List<BookCopy> bookCopies = catalog.getBookCopiesByTitle(title);

        for (BookCopy bookCopy: bookCopies)
        {
            if(bookCopy.isAvailable)
            {
                bookCopy.markIssued();
                Loan loan = new Loan(bookCopy, member);
                member.addLoan(loan);
                loans.put(loan.getId(), loan);
                System.out.println("Book borrowed: " + bookCopy.getBook().getTitle() + " by " + member.getName());
                return loan;
            }
        }

        throw new RuntimeException("No available copy");
    }

    public synchronized void returnBook(String loanId)
    {
        Loan loan = loans.get(loanId);
        loan.closeLoan();
    }

    public List<Book> searchByTitle(String title)
    {
        return catalog.searchBookByTitle(title);
    }

    public List<Book> searchByAuthor(String author)
    {
        return catalog.searchBookByAuthor(author);
    }
}
