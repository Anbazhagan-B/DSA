package LLD2.StackOverflow;

import LLD2.StackOverflow.enums.VoteType;
import LLD2.StackOverflow.interfaces.Commentable;
import LLD2.StackOverflow.interfaces.Voteable;

import java.util.ArrayList;
import java.util.List;

public class Question implements Commentable, Voteable {
    long id;
    String title;
    String content;
    String keywords;
    List<Vote> votes;
    List<Answer> answerList;
    List<Comment> commentList;
    User raisedBy;

    public Question(long id, String title, String content, String keywords)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.keywords = keywords;
        this.commentList = new ArrayList<>();
        this.answerList = new ArrayList<>();
    }

    public String getContent()
    {
        return this.content;
    }

    public void addAnswer(User user, Answer answer)
    {
        this.answerList.add(answer);
    }

    public void setRaisedBy(User raisedBy) {
        this.raisedBy = raisedBy;
    }

    public User getRaisedBy() {
        return raisedBy;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public void addComments(Comment comment) {
        commentList.add(comment);
    }

    public long getId() {
        return id;
    }

    @Override
    public List<Comment> getComments() {
        return commentList;
    }

    @Override
    public void addVote(User user, VoteType voteType) {
        if(user == null || voteType  == null)
            return;

        votes.add(new Vote(voteType));
    }

    @Override
    public int getVoteCount()
    {
        return votes.size();
    }
}
