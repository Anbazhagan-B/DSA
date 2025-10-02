package com.DsaProject.LLD.PubSubLLD;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private final Map<String, Topic> topics = new ConcurrentHashMap<String, Topic>();

    public void createTopic(String topicName)
    {
        topics.putIfAbsent(topicName, new Topic(topicName));
    }

    public void subscribe(String topicName, Subscriber subscriber)
    {
        Topic topic = topics.get(topicName);
        if(topic == null)
            throw  new RuntimeException("Topic not Found to subscribe");
        topic.addSubscriber(subscriber);
    }

    public void unSubscribe(String topicName, Subscriber subscriber)
    {
        Topic topic = topics.get(topicName);
        if(topic != null)
        {
            topic.removeSubscriber(subscriber);
        }
    }

    public void publish(String topicName, Message message)
    {
        Topic topic = topics.get(topicName);
        if(topic == null)
            throw  new RuntimeException("Topic not Found to subscribe");
        topic.boardCast(message);
    }
}
