package LLDProblems.LibraryManagementSystem.strategy;


import LLDProblems.LibraryManagementSystem.models.*;

import java.util.List;

public class SearchByAuthor implements SearchStrategy {

    @Override
    public List<Book> searchBooks(List<Book> libraryItems, String filterText) {
        if(libraryItems == null)
            throw new RuntimeException("No Library item present");

        return libraryItems.stream().filter(libraryItem -> libraryItem.getAuthorOrPublisher().contains(filterText)).toList();
    }
}
