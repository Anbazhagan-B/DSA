package com.DsaProject.IntPack.supports;

public class Edge {
    public int i;
    public int j;
    public int distance;
    public Edge(int i , int j)
    {
        this.i = i;
        this.j = j;
    }
    public Edge(int i , int j, int distance)
    {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}
