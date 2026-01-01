package LLD2.StackOverflow.interfaces;

import LLD2.StackOverflow.User;
import LLD2.StackOverflow.enums.VoteType;

public interface Voteable {
    void addVote(User user, VoteType voteType);
    int getVoteCount();
}
