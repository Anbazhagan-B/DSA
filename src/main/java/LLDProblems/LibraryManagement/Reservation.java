package LLDProblems.LibraryManagement;

import java.util.*;

public class Reservation {
    String reservationId;
    Member member;
    Book book;
    Date date;
    ReservationStatus reservationStatus;

    public Reservation(Book book, Member member)
    {
        this.book = book;
        this.member = member;
        this.date = new Date();
        this.reservationStatus = ReservationStatus.WAITING;
        this.reservationId = UUID.randomUUID().toString();
    }

    public void fullfill()
    {
        this.reservationStatus = ReservationStatus.FULFILLED;
    }

    public void cancel()
    {
        this.reservationStatus = ReservationStatus.CANCELLED;
    }
}
