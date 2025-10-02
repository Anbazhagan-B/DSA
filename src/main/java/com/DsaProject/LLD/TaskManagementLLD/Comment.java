package com.DsaProject.LLD.TaskManagementLLD;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Comment {
    String id;
    String content;
    User author;
    LocalDate timeStamp;

    public Comment(String content, User user)
    {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = user;
        this.timeStamp = LocalDate.now();
    }
}
