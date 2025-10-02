package com.DsaProject.LLD.StackOverFlowLLD;

import java.util.List;

public class Answer {
    int id;
    String content;
    User author;
    Question question;
    boolean isAccepted;
    List<Comment> comments;

    public void acceptAnswer()
    {
        this.isAccepted = true;
    }

    public Answer(String content, User author,  Question question)
    {
        this.content = content;
        this.author = author;
        this.question = question;
    }
}
