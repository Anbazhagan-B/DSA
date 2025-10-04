package LLDProblems.Auction.models;

public class Bid {
    double bidAmount;
    User placedBy;

    public Bid(Double bidAmount, User placedBy)
    {
        this.bidAmount = bidAmount;
        this.placedBy = placedBy;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public User getPlacedBy() {
        return placedBy;
    }
}
