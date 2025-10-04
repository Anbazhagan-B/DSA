package LLDProblems.LibraryManagementSystem.models;


public class Magazine extends LibraryItem {
    String publisher;
    public Magazine(String title, String publisher)
    {
        super(title);
        this.publisher = publisher;
    }

    public String getAuthorOrPublisher()
    {
        return publisher;
    }
}
