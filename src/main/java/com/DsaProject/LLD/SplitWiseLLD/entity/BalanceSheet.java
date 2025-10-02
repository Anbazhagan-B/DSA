package com.DsaProject.LLD.SplitWiseLLD.entity;

import java.util.*;

public class BalanceSheet {
    User owner;
    Map<User, Double> balances;

    public BalanceSheet(User owner){
        this.owner = owner;
        balances = new HashMap<>();
    }

    public Map<User, Double> getBalances()
    {
        return this.balances;
    }

    public void showBalances()
    {
        if(balances.isEmpty())
        {
            System.out.println("All settled up!");
            return;
        }

        double totalOwedToMe = 0;
        double totalOwe = 0;

        for(Map.Entry<User, Double> entry: balances.entrySet())
        {
            User otherUser = entry.getKey();
            double amount = entry.getValue();

            if(amount > 0.01)
            {
                System.out.println(otherUser.getName() + " owes " + owner.getName() + " $" + String.format("%.2f", amount));
                totalOwedToMe += amount;
            }
            else if(amount < -0.01)
            {
                System.out.println(owner.getName() + " owes " + otherUser.getName() + " $" + String.format("%.2f", amount));
                totalOwedToMe += (-amount);
            }
        }


    }

    public synchronized void adjustBalance(User other, double amount)
    {
        if(owner.equals(other))
        {
            return;
        }
        balances.merge(other, amount, Double::sum);

    }
}
