package LLDProblems.LibraryManagementSystem;


import LLDProblems.LibraryManagementSystem.models.*;
import LLDProblems.LibraryManagementSystem.state.*;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<String, BookCopy> catalog;
    Map<String, Member> members;
    Map<String, Loan> loans;

    public LibrarySystem()
    {
        this.catalog = new HashMap<>();
        this.members = new HashMap<>();
        this.loans = new HashMap<>();
    }

    public Member addMember(String name)
    {
        Member member = new Member(name);
        members.put(member.getMemberId(), member);
        return member;
    }

    public LibraryItem addItem(String itemType, String title, String author, int numOfCopies)
    {
        LibraryItem libraryItem = null;
        switch (itemType)
        {
            case "book":
                libraryItem = new Book(title, author);
            case "magazine":
                libraryItem = new Magazine(title, author);
        }

        for (int i = 0; i < numOfCopies; i++)
        {
            BookCopy bookCopy = new BookCopy();
            if(libraryItem != null)
            {
                libraryItem.addCopies(bookCopy);
            }
        }

        return libraryItem;
    }

    public void checkOut(BookCopy bookCopy, Member member)
    {
        bookCopy.setItemState(new CheckedOutState());
        bookCopy.checkOut(member);
    }

    public void returnItem(BookCopy bookCopy, Member member)
    {
        bookCopy.returnItem();
        bookCopy.setItemState(new AvailableState());
    }
}
