package LLDProblems.LibraryManagementSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member {
    String memberId;
    String name;
    List<Loan> loans;
    public Member(String name)
    {
        this.memberId = UUID.randomUUID().toString();
        this.name = name;
        this.loans = new ArrayList<>();
    }

    public void addLoan(Loan loan)
    {
        if(this.loans == null)
            throw new RuntimeException("Loan cannot be null");
        this.loans.add(loan);
    }

    public void checkOut(Loan loan)
    {
        if(!loans.contains(loan))
            throw new RuntimeException("No loan exist");
        loans.remove(loan);
    }

    public String getMemberId()
    {
        return this.memberId;
    }
}
