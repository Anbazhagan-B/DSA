package com.DsaProject.LLD.VendingMachine;

public enum Coins {
    PENNY(1),
    NIKKAL(5);

    private final int value;

    Coins(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }
}
