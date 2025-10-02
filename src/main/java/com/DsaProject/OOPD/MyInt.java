package com.DsaProject.OOPD;

public interface MyInt {

    void showName();

    default void showNameHelper()
    {
        System.out.println("Helper");
    }
}
