package com.DsaProject.LLD.HotelManagementSystemLLD;

public class Room {
    String id;
    RoomType roomType;
    double price;
    RoomStatus status;

    public Room(String id, RoomType type, double price, RoomStatus status)
    {
        this.id = id;
        this.roomType = type;
        this.price = price;
        this.status = status;
    }

    public synchronized void book()
    {
        if(this.status == RoomStatus.AVAILABLE)
        {
            this.status = RoomStatus.BOOKED;
        }
        else
        {
            throw new RuntimeException("Room is not available");
        }

    }

    public synchronized void checkIn()
    {
        if(this.status == RoomStatus.BOOKED)
        {
            this.status = RoomStatus.OCCUPIED;
        }
        else
        {
            throw new RuntimeException("Room is not available to checkIn");
        }
    }

    public synchronized void checkout()
    {
        if(this.status == RoomStatus.OCCUPIED)
        {
            this.status = RoomStatus.AVAILABLE;
        }
        else
        {
            throw new RuntimeException("Room is not available to checkout");
        }
    }

    public String getId()
    {
        return this.id;
    }

    public double getPrice() {
        return price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}
