package LLDProblems.LibraryManagement;

import java.util.*;

public class ReservationManager {
    public Map<Book, Queue<Reservation>> reservationQueue;

    public ReservationManager()
    {
        reservationQueue = new HashMap<>();
    }

    public Reservation reserveBook(Book book, Member member)
    {
        if(!member.canBarrow())
            throw new IllegalStateException("Member cannot barrow book");

        Reservation reservation = new Reservation(book, member);
        reservationQueue.computeIfAbsent(book, k -> new LinkedList<>()).add(reservation);
        member.reservations.add(reservation);

        return reservation;
    }
}
