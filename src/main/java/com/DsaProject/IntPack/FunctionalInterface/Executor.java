package com.DsaProject.IntPack.FunctionalInterface;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        System.out.println(mostFrequentCharacter("asaadde"));
    }

    public void executeNumeric()
    {
        System.out.println(numericOperation.sum(5, 3));
        System.out.println(numericOperation.subtrack(5, 3));
        System.out.println(numericOperation.multiply(5, 3));
        System.out.println(numericOperation.divide(5, 3));
    }

    public Character mostFrequentCharacter(String chars)
    {
        return chars.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }
}
