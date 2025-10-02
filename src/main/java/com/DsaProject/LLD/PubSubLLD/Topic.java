package com.DsaProject.LLD.PubSubLLD;


import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    String name;
    Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public Topic(String topicName)
    {
        this.name = topicName;
    }

    public String getName()
    {
        return this.name;
    }

    public void addSubscriber(Subscriber subscriber)
    {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber)
    {
        subscribers.add(subscriber);
    }

    public void boardCast(Message message)
    {
        for(Subscriber subscriber : subscribers)
        {
            Dispatcher.dispatch(subscriber, message);
        }
    }
}
