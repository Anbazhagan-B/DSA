package LLDProblems.LibraryManagementSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LibraryItem {
    String id;
    List<BookCopy> copies;
    String title;

    public LibraryItem(String title)
    {
        this.copies = new ArrayList<>();
        this.title = title;
        this.id = UUID.randomUUID().toString();
    }

    public void addCopies(BookCopy bookCopy)
    {
        if(this.copies == null)
            throw new RuntimeException("Book copy cannot be added");
        this.copies.add(bookCopy);
    }

    public List<BookCopy> getCopies()
    {
        if(this.copies == null)
            throw new RuntimeException("No BookCopy exists");
        return this.copies;
    }

    public String getTitle()
    {
        return this.title;
    }
}
