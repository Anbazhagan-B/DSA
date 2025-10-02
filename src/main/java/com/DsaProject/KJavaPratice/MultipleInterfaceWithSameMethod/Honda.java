package com.DsaProject.KJavaPratice.MultipleInterfaceWithSameMethod;

public class Honda implements Car, Car2 {

    @Override
    public void print() {
        System.out.println("The Car is implemented");
    }
}
