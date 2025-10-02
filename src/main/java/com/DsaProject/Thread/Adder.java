package com.DsaProject.Thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Adder implements Callable<ArrayList<Integer>> {
    Integer n;
    public Adder(Integer n)
    {
        this.n = n;
    }

    @Override
    public ArrayList<Integer> call()
    {
        ArrayList<Integer> result = new ArrayList<>();
        Integer i =0;
        while (i < this.n)
        {
            result.add(i);
            i++;
        }

        return result;
    }
}
