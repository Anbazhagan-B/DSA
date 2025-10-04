package LLDProblems.Auction.models;



import LLDProblems.Auction.enums.AuctionStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Auction {
    String auctionId;
    String auctionItem;
    LocalDateTime endTime;
    double startingPrice;
    Bid winningBid;
    List<Bid> bids;
    User createdBy;
    AuctionStatus auctionStatus;

    public Auction(String auctionItem, LocalDateTime endTime, double startingPrice, User createdBy)
    {
        this.auctionId = UUID.randomUUID().toString();
        this.auctionItem = auctionItem;
        this.endTime = endTime;
        this.startingPrice = startingPrice;
        this.createdBy = createdBy;
        this.bids = new ArrayList<>();
        this.auctionStatus = AuctionStatus.Pending;
    }

    public boolean isActive()
    {
        return this.auctionStatus == AuctionStatus.Active;
    }

    public void closeAuction()
    {
        if(bids.isEmpty())
            throw new IllegalArgumentException("No active bids");

        winningBid = bids.get(0);
        for (Bid bid : bids)
        {
            if(bid.getBidAmount() >= winningBid.getBidAmount())
            {
                setWinningBid(bid);
            }
        }
        System.out.printf("The wining bid %s is placed by %s", winningBid.getBidAmount(), winningBid.getPlacedBy().getName());
    }

    public String getAuctionId()
    {
        return this.auctionId;
    }

    void setWinningBid(Bid bid)
    {
        this.winningBid = bid;
    }

    public Bid getWinningBid() {
        return winningBid;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public String getAuctionItem() {
        return auctionItem;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public void addBid(Bid bid) {

        if(this.bids == null)
        {
            this.bids = new ArrayList<>();
        }

        this.bids.add(bid);
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

}
