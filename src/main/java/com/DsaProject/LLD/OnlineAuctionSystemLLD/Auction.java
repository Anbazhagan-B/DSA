package com.DsaProject.LLD.OnlineAuctionSystemLLD;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Auction {
    String id;
    Item item;
    Date startTime;
    Date endTime;
    AuctionStatus status;
    Bid highestBid;
    List<Bid> bidHistory;

    public Auction(User user, Item item, double startingPrice, Date startTime, Date endTime)
    {
        this.id = UUID.randomUUID().toString();
        this.item = item;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = AuctionStatus.ACTIVE;
        highestBid = new Bid(user, startingPrice);
        bidHistory = new CopyOnWriteArrayList<>();
    }

    public synchronized void placeBid(Bid bid)
    {
        if(status == AuctionStatus.CLOSED)
            throw new RuntimeException("Auction already ended");

        if(bid.getAmount() < highestBid.getAmount())
            throw new RuntimeException("Bid amount is not enough");
        highestBid = bid;
        bidHistory.add(bid);
        System.out.println("New highest bid: " + bid.getAmount() + " by " + bid.getBidder().getUserName());

    }

    public synchronized void closeAuction()
    {
        if(status == AuctionStatus.CLOSED) return;

        status = AuctionStatus.CLOSED;

        System.out.println("Auction for " + item.getName() + " closed. Winner: " + highestBid.getBidder().getUserName() +
                " with " + highestBid.getAmount());
    }

    public boolean isActive() {
        return this.status == AuctionStatus.ACTIVE && new Date().before(endTime);
    }

    public String getId()
    {
        return this.id;
    }

    public Bid getHighestBid()
    {
        return this.highestBid;
    }

    public Item getItem()
    {
        return this.item;
    }

    public AuctionStatus getStatus()
    {
        return this.status;
    }
}
