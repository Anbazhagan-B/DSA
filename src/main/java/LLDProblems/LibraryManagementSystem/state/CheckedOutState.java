package LLDProblems.LibraryManagementSystem.state;


import LLDProblems.LibraryManagementSystem.models.*;

public class CheckedOutState implements ItemState {
    @Override
    public void checkOut(BookCopy bookCopy, Member member) {
        System.out.print("Already CheckedOut the book copy");
    }

    @Override
    public void returnItem(BookCopy bookCopy) {
        bookCopy.setItemState(new AvailableState());
        System.out.print("Book copy  is returned");
    }
}
