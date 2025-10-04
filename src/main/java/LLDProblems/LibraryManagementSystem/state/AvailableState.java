package LLDProblems.LibraryManagementSystem.state;

import LLDProblems.LibraryManagementSystem.models.*;

public class AvailableState implements ItemState{

    @Override
    public void checkOut(BookCopy bookCopy, Member member) {

        bookCopy.setItemState(new CheckedOutState());
        System.out.print("Book copy checked out by "+member.getMemberId());
    }

    @Override
    public void returnItem(BookCopy bookCopy) {
        System.out.print("Item cannot be returned, It must be loaned first");
    }
}
