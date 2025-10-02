package LLDProblems.LibraryManagement;

import java.util.Date;

public class BookCopy {
    int bookCopyId;
    BookCopyStatus bookCopyStatus;
    Date dueDate;
    Book book;

    public boolean isAvailable(){
        return bookCopyStatus == BookCopyStatus.AVAILABLE;
    }
}
