package com.DsaProject.LLD.SplitWiseLLD.entity;

import java.util.*;

public class Group {
    String id;
    String name;
    List<User> members;

    public Group(String name, List<User> members)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.members = members;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public List<User> getMembers()
    {
        return new ArrayList<>(members);
    }
}
