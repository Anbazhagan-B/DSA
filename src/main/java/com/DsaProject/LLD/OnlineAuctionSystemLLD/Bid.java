package com.DsaProject.LLD.OnlineAuctionSystemLLD;

import java.time.LocalDateTime;

public class Bid {
    int id;
    User bidder;
    double amount;
    LocalDateTime timeStamp;
    public Bid(User user, double biddingPrice)
    {
        this.bidder = user;
        this.amount = biddingPrice;
    }
    public double getAmount()
    {
        return this.amount;
    }

    public User getBidder()
    {
        return this.bidder;
    }
}
