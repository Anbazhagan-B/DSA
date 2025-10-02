package com.DsaProject.SplitEasy.enitiy;

import java.util.List;

public class Split {
    public String name;
    public String description;
    public int id;
    public double transactionAmount;
    public User spentby;
    public User ownedBy;
    public List<User> participants;

    public Split(String name, String description, double transactionAmount, User ownedBy, List<User> participants)
    {
        this.name = name;
        this.description = description;
        this.transactionAmount = transactionAmount;
        this.ownedBy = ownedBy;
        this.participants = participants;
    }

    public int getId()
    {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public User getSpentby() {
        return spentby;
    }

    public User getOwnedBy() {
        return ownedBy;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
