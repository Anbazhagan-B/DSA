package LLDProblems.LibraryManagement;

import java.util.List;

public class Book {
    String bookName;
    String authorName;
    String ISBN;
    BookType bookType;
    List<BookCopy> bookCopyList;

    public List<BookCopy> getAvailableBookCopies()
    {
        return bookCopyList.stream().filter(bookCopy -> bookCopy.bookCopyStatus == BookCopyStatus.AVAILABLE).toList();
    }

    public void addBookCopy(BookCopy bookCopy)
    {
        bookCopyList.add(bookCopy);
    }
}
