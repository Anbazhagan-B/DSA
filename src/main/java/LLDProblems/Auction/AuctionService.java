package LLDProblems.Auction;

import LLDProblems.Auction.models.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AuctionService {
    Map<String, User> users;
    Map<String, Auction> auctions;
    ScheduledExecutorService auctionExecutor;

    AuctionService()
    {
        this.users = new HashMap<>();
        this.auctions = new HashMap<>();
        auctionExecutor = Executors.newScheduledThreadPool(10);
    }

    public User createUser(String name){

        if(name.isEmpty())
            throw new IllegalArgumentException("User name should have proper value");

        User user = new User(name);
        users.put(user.getId(), user);

        return user;
    }


    public Auction createAuction(String auctionItem, LocalDateTime endTime, double startingPrice, User createdBy)
    {
        Auction auction = new Auction(auctionItem, endTime, startingPrice, createdBy);
        auctions.put(auction.getAuctionId(), auction);
        long auctionTimeDuration = Duration.between(LocalDateTime.now(), endTime).toMillis();
        auctionExecutor.schedule(() -> endAuction(auction), auctionTimeDuration, TimeUnit.MILLISECONDS);
        System.out.printf("New auction created for '%s' (ID: %s), ending at %s.\n", auctionItem, auction.getAuctionId(), endTime);
        return auction;
    }

    public List<Auction> getActiveAuctions()
    {
        if(this.auctions.isEmpty())
            throw new IllegalArgumentException("No active auction present");

        return this.auctions.values().stream().filter(Auction::isActive).toList();
    }

    public void placeBid(Auction auction, Bid bid)
    {
        if(bid == null || bid.getBidAmount() == 0)
            throw new IllegalStateException("Provide proper bid value");

        auction.addBid(bid);
    }

    public void endAuction(Auction auction)
    {
        if(auction == null)
            throw new IllegalArgumentException("No auction found");
        auction.closeAuction();
    }
}
