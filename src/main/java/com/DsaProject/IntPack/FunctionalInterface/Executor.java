package com.DsaProject.IntPack.FunctionalInterface;

public class Executor {
    Calculator calculator;
    NumericOperation numericOperation;
    public Executor(Calculator calculator)
    {
        this.calculator = calculator;
    }
    public Executor(NumericOperation numericOperation)
    {
        this.numericOperation = numericOperation;
    }

    public void execute()
    {
        calculator.operate(1, 2);
    }

    public void executeNumeric()
    {
        System.out.println(numericOperation.sum(5, 3));
        System.out.println(numericOperation.subtrack(5, 3));
        System.out.println(numericOperation.multiply(5, 3));
        System.out.println(numericOperation.divide(5, 3));
    }
}
