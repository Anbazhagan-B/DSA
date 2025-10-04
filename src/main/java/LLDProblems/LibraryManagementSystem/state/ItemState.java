package LLDProblems.LibraryManagementSystem.state;

import LLDProblems.LibraryManagementSystem.models.*;

public interface ItemState {
    void checkOut(BookCopy bookCopy, Member member);
    void returnItem(BookCopy bookCopy);
    //void placeHold(BookCopy bookCopy, Member member);
}
