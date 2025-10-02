package com.DsaProject.IntPack;

public class Square extends Shape implements IShape{

    public Square(float size) {
        super(size);
    }

    public void calculateArea()
    {
        System.out.println("Square calculateArea" + extraArea);
    }


}
