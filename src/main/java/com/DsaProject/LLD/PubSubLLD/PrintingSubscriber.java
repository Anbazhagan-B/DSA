package com.DsaProject.LLD.PubSubLLD;

public class PrintingSubscriber implements Subscriber{
    String name;

    public PrintingSubscriber(String name)
    {
        this.name = name;
    }

    @Override
    public void consume(Message message) {
        System.out.println("Subscriber " + name + " received message: " + message.getPayload());
    }
}
