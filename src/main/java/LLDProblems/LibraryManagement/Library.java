package LLDProblems.LibraryManagement;
import java.util.*;

public class Library {
    String name;
    String address;
    Catalog catalog;
    List<Member> memberList;
    ReservationManager reservationManager;

    public Library(String name, String address)
    {
        this.name = name;
        this.address = address;
        this.catalog = new Catalog();
        this.memberList = new ArrayList<>();
        this.reservationManager = new ReservationManager();
    }

    public Lending checkoutBook(Book book, Member member)
    {
        if(!member.canBarrow())
        {
            throw new IllegalStateException("Member cannot borrower book");
        }

        Book book1 = catalog.findBookByISBN(book.ISBN);
        if(book1 == null)
            throw new IllegalStateException("Book does not exists in Libraby");

        List<BookCopy> bookCopyList =  book1.bookCopyList;
        if(bookCopyList .isEmpty())
        {
            this.reservationManager.reserveBook(book, member);
            throw new IllegalStateException("No Copies available");
        }

        BookCopy bookCopy = bookCopyList.get(0);
        Date checkoutDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkoutDate);
        calendar.add(Calendar.DAY_OF_WEEK, book.bookType.getLateFee());
        Date dueDate = calendar.getTime();

        return new Lending(member, bookCopy, dueDate, checkoutDate);
    }

    public void addBook(Book book)
    {
        this.catalog.addBook(book);
    }

    public void addMember(Member member)
    {
        this.memberList.add(member);
    }

    public double returnBook(Lending lending, Date dueDate)
    {
        return lending.returnBook(dueDate);
    }
}
