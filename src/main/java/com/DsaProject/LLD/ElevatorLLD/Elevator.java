package com.DsaProject.LLD.ElevatorLLD;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    int id;
    int capacity;
    int currentFloor;
    Direction direction;
    List<Request> requests;
    public Elevator(int id, int capacity)
    {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 0;
        this.direction = Direction.UP;
        requests = new ArrayList<>();
    }
    public synchronized void addRequest(Request request)
    {
        if(requests.size() < capacity)
        {
            requests.add(request);
            System.out.println("Elevator " + id + " added request: " + request);
            notifyAll();
        }
    }

    public synchronized Request getNextRequest()
    {
        while (requests.isEmpty())
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        return requests.remove(0);
    }

    public synchronized void processRequest()
    {
        while (true)
        {
            while (!requests.isEmpty())
            {
                Request request = getNextRequest();
                processRequest(request);
                try {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void processRequest(Request request)
    {
        int startFloor = this.currentFloor;
        int destination = request.getDestinationFloor();

        if(startFloor < destination)
        {
            direction = Direction.UP;

            for (int i = startFloor; i <= destination; i++)
            {
                currentFloor = i;
                System.out.println("Elevator " + id + " reached floor " + currentFloor);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            direction = Direction.DOWN;

            for (int i = startFloor; destination >= i; i--)
            {
                currentFloor = i;
                System.out.println("Elevator " + id + " reached floor " + currentFloor);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run()
    {
        processRequest();
    }

    public int getCurrentFloor()
    {
        return this.currentFloor;
    }

    public Direction getCurrentDirection()
    {
        return this.direction;
    }
}
