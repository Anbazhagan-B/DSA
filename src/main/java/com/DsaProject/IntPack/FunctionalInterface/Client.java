package com.DsaProject.IntPack.FunctionalInterface;

public class Client {
    public static void main(String[] args)
    {
//        Executor executor = new Executor(new NumericCalculator());
//        executor.execute();
//        StreamPractice streamPractice = new StreamPractice();
//        streamPractice.execute();

        Executor executor = new Executor(new NumericOperation());
        executor.executeNumeric();

    }
}
