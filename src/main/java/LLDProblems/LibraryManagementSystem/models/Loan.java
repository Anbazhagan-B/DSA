package LLDProblems.LibraryManagementSystem.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Loan {
    String id;
    BookCopy bookCopy;
    Member member;
    LocalDateTime localDateTime;

    public Loan(BookCopy bookCopy, Member member)
    {
        this.id = UUID.randomUUID().toString();
        localDateTime = LocalDateTime.now();
        this.bookCopy = bookCopy;
        this.member = member;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public Member getMember() {
        return member;
    }
}
