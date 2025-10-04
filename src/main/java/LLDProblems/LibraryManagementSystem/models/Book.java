package LLDProblems.LibraryManagementSystem.models;


public class Book extends LibraryItem {
    String author;

    public Book(String title, String author)
    {
        super(title);
        this.author = author;
    }

    public String getAuthorOrPublisher()
    {
        return this.author;
    }
}
