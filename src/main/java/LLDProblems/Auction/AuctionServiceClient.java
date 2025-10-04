package LLDProblems.Auction;

import LLDProblems.Auction.models.*;

import java.time.LocalDateTime;

public class AuctionServiceClient
{
    public static void main(String[] args)
    {

        AuctionService auctionService = new AuctionService();

        User anbu = auctionService.createUser("anbu");
        User anbu1 = auctionService.createUser("anbu1");
        User anbu2 = auctionService.createUser("anbu2");
        User anbu3 = auctionService.createUser("anbu3");

        User deva = auctionService.createUser("deva");

        Auction auction = auctionService.createAuction("Deva's Guiter", LocalDateTime.now().plusSeconds(10), 20.0, anbu);

        auctionService.placeBid(auction, new Bid(40.0, anbu1));
        auctionService.placeBid(auction, new Bid(60.0, anbu2));
        auctionService.placeBid(auction, new Bid(20.0, anbu3));
    }
}