package com.DsaProject.IntPack.FunctionalInterface;

public class NumericOperation implements INumericOperation{
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int subtrack(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a/b;
    }
}
