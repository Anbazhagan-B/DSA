package com.DsaProject.LLD.SnakeAndLadderLLD.models;

import com.DsaProject.LLD.cricinfo.entity.Match;

public class Dice {
    int minValue;
    int maxValue;

    public Dice(int minValue, int maxValue)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int roll()
    {
        return (int)Math.random() * (maxValue - minValue + 1) + minValue;
    }
}
