package com.DsaProject.IntPack.FunctionalInterface;

public class Executor {
    Calculator calculator;
    public Executor(Calculator calculator)
    {
        this.calculator = calculator;
    }

    public void execute()
    {
        calculator.operate(1, 2);
    }
}
