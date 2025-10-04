package LLDProblems.LibraryManagementSystem;


import LLDProblems.LibraryManagementSystem.models.*;

public class LibraryManagementSystemClient {
    public static void main(String[] args)
    {
        LibrarySystem librarySystem = new LibrarySystem();

        Member member = new Member("Anbu");

        LibraryItem libraryItem = librarySystem.addItem("book", "F1", "De arms", 5);
        LibraryItem libraryItem1 = librarySystem.addItem("book", "F2", "De arms of journal", 5);

        librarySystem.checkOut(libraryItem.getCopies().get(0), member);
    }
}
