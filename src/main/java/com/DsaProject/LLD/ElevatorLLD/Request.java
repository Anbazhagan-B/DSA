package com.DsaProject.LLD.ElevatorLLD;

public class Request {
    int sourceFloor;
    int destinationFloor;
    public Request(int sourceFloor, int destinationFloor){
        this.destinationFloor = destinationFloor;
        this.sourceFloor = sourceFloor;
    }

    public int getSourceFloor()
    {
        return this.sourceFloor;
    }

    public int getDestinationFloor()
    {
        return this.destinationFloor;
    }
}
