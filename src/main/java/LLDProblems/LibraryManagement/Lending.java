package LLDProblems.LibraryManagement;

import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Lending {
    Integer lendingId;
    Member member;
    BookCopy bookCopy;
    Date dueDate;
    Date returnDate;
    Date checkOutDate;

    public Lending(Member member, BookCopy bookCopy, Date dueDate, Date returnDate)
    {
        this.member = member;
        this.bookCopy = bookCopy;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public double returnBook(Date returnDate)
    {
        this.returnDate = returnDate;
        bookCopy.bookCopyStatus = BookCopyStatus.AVAILABLE;
        member.currentLending.remove(this);

        if(returnDate.after(dueDate))
        {
            long dayUnit = ChronoUnit.DAYS.between(returnDate.toInstant(), dueDate.toInstant());
            double fee = dayUnit * bookCopy.book.bookType.getDailyFineAmount();
            member.addFee(fee);
            return  fee;

        }
        return 0.0;
    }
}
