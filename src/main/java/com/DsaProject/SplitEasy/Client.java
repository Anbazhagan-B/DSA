package com.DsaProject.SplitEasy;

import com.DsaProject.SplitEasy.enitiy.Split;
import com.DsaProject.SplitEasy.enitiy.SplitAmt;
import com.DsaProject.SplitEasy.enitiy.SplitType;
import com.DsaProject.SplitEasy.enitiy.User;

import java.util.*;
import java.util.concurrent.TransferQueue;

public class Client {
    public static void main(String[] args)
    {
        User A = new User();
        A.name = "A";
        User B = new User();
        B.name = "B";
        User C = new User();
        B.name = "B";
        User D = new User();
        B.name = "B";
        Split split = new Split("Trip 1", "Trip 1", 100, A,  new ArrayList<>(List.of(A, C)));
        Split split1 = new Split("Trip 2", "Trip 2", 220, B,  new ArrayList<>(List.of(D, A)));
        Split split2 = new Split("Trip 3", "Trip 3", 160, D,  new ArrayList<>(List.of(A, B, C, D)));
        Split split3 = new Split("Trip 4", "Trip 4", 50, C,  new ArrayList<>(List.of(A)));

        List<Split> splits = new ArrayList<>(List.of(split1, split2,split, split3));


        Map<String, SplitAmt> userBalances = new HashMap<>();

        for (Split currentSplit : splits) {
            double amount = currentSplit.transactionAmount;
            User paidBy = currentSplit.ownedBy;
            List<User> participants = currentSplit.participants;
            int numParticipants = participants.size();
            double share = amount / numParticipants;

            for (User participant : participants) {
                userBalances.computeIfPresent(participant.name, (k, splitAmt) -> new SplitAmt(splitAmt.amount - amount, SplitType.debit));
            }

            userBalances.put(paidBy.name,
                    userBalances.computeIfPresent(paidBy.name, (k, splitAmt) -> new SplitAmt(splitAmt.amount + amount, SplitType.credit)));
        }


        PriorityQueue<Map.Entry<String, SplitAmt>> creditors = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getValue().amount, a.getValue().amount)
        );
        PriorityQueue<Map.Entry<String, SplitAmt>> debtors = new PriorityQueue<>(
                (a, b) -> Double.compare(a.getValue().amount, b.getValue().amount)
        );

        for (Map.Entry<String, SplitAmt> entry : userBalances.entrySet()) {
            if (entry.getValue().splittype == SplitType.credit) {
                creditors.offer(entry);
            } else if (entry.getValue().splittype == SplitType.debit) {
                debtors.offer(entry);
            }
        }

        while (!creditors.isEmpty() && !debtors.isEmpty()) {
            Map.Entry<String, SplitAmt> creditor = creditors.poll();
            Map.Entry<String, SplitAmt> debtor = debtors.poll();

            double settleAmount = Math.min(creditor.getValue().amount, - debtor.getValue().amount);

            System.out.printf("%s owes ₹%.2f to %s%n", debtor.getKey(), settleAmount, creditor.getKey());

            double newCreditorBal = creditor.getValue().amount - settleAmount;
            double newDebtorBal = debtor.getValue().amount + settleAmount;

            if (newCreditorBal > 0.01) {
                creditors.offer(new AbstractMap.SimpleEntry<>(creditor.getKey(), new SplitAmt(newCreditorBal, SplitType.credit)));
            }

            if (newDebtorBal < -0.01) {
                debtors.offer(new AbstractMap.SimpleEntry<>(debtor.getKey(), new SplitAmt(newCreditorBal, SplitType.debit)));
            }
        }

    }
}
