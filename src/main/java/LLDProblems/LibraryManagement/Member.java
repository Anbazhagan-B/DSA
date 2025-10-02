package LLDProblems.LibraryManagement;

import java.util.List;

public class Member {
    int memberId;
    String name;
    String email;
    Integer phoneNumber;
    List<Lending> currentLending;
    List<Reservation> reservations;
    double outstandingAmount;

    public void addFee(double fee)
    {
        outstandingAmount = outstandingAmount + fee;
    }

    public boolean canBarrow()
    {
        return outstandingAmount == 0;
    }

    public void payOutStandingAmount(int amount)
    {
        outstandingAmount = outstandingAmount + amount;
    }
}
