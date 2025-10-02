package com.DsaProject.LLD.PubSubLLD;

public class Publisher {
    String id;
    Broker broker;

    public Publisher( String id, Broker broker)
    {
        this.id = id;
        this.broker = broker;
    }

    public void publish(String topic, String payload)
    {
        this.broker.publish(topic, new Message(payload));
    }

    public String getId()
    {
        return this.id;
    }
}
