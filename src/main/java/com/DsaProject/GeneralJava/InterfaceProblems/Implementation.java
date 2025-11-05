package com.DsaProject.GeneralJava.InterfaceProblems;

public class Implementation implements Interface1, Interface2{
    @Override
    public void move() {
        Interface1.super.move();
    }
}
