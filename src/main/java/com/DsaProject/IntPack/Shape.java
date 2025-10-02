package com.DsaProject.IntPack;


public class Shape extends ShapeHelper implements IShape
{
    float size;
    public Shape(float size)
    {
        this.size = size;
    }

    public void calculateArea()
    {
        System.out.println("Shape calculateArea" + this.size * this.sum(2, 3));
    }

    @Override
    public int calculateHeight() {
        return 0;
    }
}
