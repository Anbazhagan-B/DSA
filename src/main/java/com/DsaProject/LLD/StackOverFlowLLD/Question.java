package com.DsaProject.LLD.StackOverFlowLLD;

import java.util.List;

public class Question {
    int id;
    String title;
    String content;
    User postedBy;
    List<Comment> comments;
    List<Answer> answers;
    Answer acceptedAnswer;

    public int getId()
    {
        return this.id;
    }

    public Question(String title, String content, User postedBy)
    {
        this.title = title;
        this.content = content;
        this.postedBy = postedBy;
    }
}
