package LLDProblems.LibraryManagement;

import java.util.*;

public class Catalog {
    Map<String, Book> bookByISBN;

    public Catalog()
    {
        this.bookByISBN = new HashMap<>();
    }

    public void addBook(Book book)
    {
        bookByISBN.put(book.ISBN, book);
    }

    public Book findBookByISBN(String isbn)
    {
        return bookByISBN.get(isbn);
    }

    public List<Book> searchBooks(String bookName)
    {
        return bookByISBN.values().stream().filter(book -> book.bookName.contains(bookName)).toList();
    }
}
