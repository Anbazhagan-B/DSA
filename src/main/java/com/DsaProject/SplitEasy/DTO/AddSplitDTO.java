package com.DsaProject.SplitEasy.DTO;

import com.DsaProject.SplitEasy.enitiy.User;

import java.util.List;

public class AddSplitDTO {
    double amount;
    User createdBy;
    User ownedBy;
    List<User> participants;

    public double getAmount()
    {
        return amount;
    }

    public User getOwnedBy() {
        return ownedBy;
    }
    public User getCreatedBy()
    {
        return createdBy;
    }

    public List<User> getParticipants() {
        return participants;
    }
}
