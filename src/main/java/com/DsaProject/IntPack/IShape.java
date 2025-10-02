package com.DsaProject.IntPack;

public interface IShape {
    int extraArea = 0;
    default int sum(int a, int b)
    {
        return a + b;
    }
    void calculateArea();
}
