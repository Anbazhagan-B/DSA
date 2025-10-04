package LLDProblems.LibraryManagementSystem.models;


import LLDProblems.LibraryManagementSystem.state.AvailableState;
import LLDProblems.LibraryManagementSystem.state.ItemState;

import java.util.UUID;

public class BookCopy {
    String id;
    LibraryItem libraryItem;
    ItemState itemState;

    public BookCopy(){
        this.id = UUID.randomUUID().toString();
        this.itemState = new AvailableState();
    }

    public void checkOut(Member member)
    {
        itemState.checkOut(this, member);
    }

    public void returnItem()
    {
        itemState.returnItem(this);
    }

    public void setItemState(ItemState itemState)
    {
        this.itemState = itemState;
    }
}
