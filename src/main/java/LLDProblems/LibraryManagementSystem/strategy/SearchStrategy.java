package LLDProblems.LibraryManagementSystem.strategy;


import LLDProblems.LibraryManagementSystem.models.*;

import java.util.List;

public interface SearchStrategy {
    List<Book>  searchBooks(List<Book> libraryItems, String filterText);
}
