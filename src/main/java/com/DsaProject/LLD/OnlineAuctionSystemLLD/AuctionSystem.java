package com.DsaProject.LLD.OnlineAuctionSystemLLD;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AuctionSystem {
    static AuctionSystem instance;
    Map<String, User> users;
    Map<String, Auction> auctions;
    ScheduledExecutorService scheduler;

    public AuctionSystem() {
        this.auctions = new HashMap<>();
        this.users = new HashMap<>();
        scheduler = Executors.newScheduledThreadPool(1);
    }

    public static AuctionSystem getInstance() {
        if (instance == null) {
            return new AuctionSystem();
        }
        return instance;
    }

    public User registerUser(String username, String email)
    {
        User user = new User(username, email);
        users.put(username, user);
        return user;
    }

    public User getUser(String username)
    {
        return users.get(username);
    }

    public Auction createAuction(User user, Item item, double startingPrice, Date startingDate, Date endDate)
    {
        Auction auction = new Auction(user, item, startingPrice, startingDate, endDate);
        auctions.put(auction.getId(), auction);

        long delay = endDate.getTime() - new Date().getTime();
        scheduler.schedule(auction::closeAuction, delay, TimeUnit.MILLISECONDS);

        System.out.println("Auction created: " + auction.getId());
        return auction;
    }

    public void placeBid(String auctionId, Bid bid)
    {
        Auction auction =  auctions.get(auctionId);

        if(auction == null) throw  new RuntimeException("Auction Not exists");

        auction.placeBid(bid);
    }

    public List<Auction> viewActiveAuctions()
    {
        return auctions.values().stream().filter(Auction::isActive).toList();
    }

    public void shutdown()
    {
        this.scheduler.shutdown();
    }
}
