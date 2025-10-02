package com.DsaProject.LLD.PubSubLLD;

public class LoggingSubscriber implements Subscriber{
    String name;

    public LoggingSubscriber(String name)
    {
        this.name = name;
    }

    @Override
    public void consume(Message message) {
        System.out.println("Subscriber " + name + " received message: " + message.getPayload());
    }
}
