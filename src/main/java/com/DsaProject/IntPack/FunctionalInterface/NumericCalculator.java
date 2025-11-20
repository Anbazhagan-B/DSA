package com.DsaProject.IntPack.FunctionalInterface;

import java.util.*;
import java.util.stream.Collectors;

public class NumericCalculator implements Calculator{

    @Override
    public int operate1(int operand1, int operand2) {
        return 0;
    }

    @Override
    public int operate(int operand1, int operand2) {
        System.out.println("Numeric Calculator :- ");

        List<String> names = Arrays.asList("john", "jane", "bob");
        Map<Integer, String> map = names.stream()
                .collect(Collectors.toMap(
                        String::length,
                        String::toUpperCase
                ));

        return 0;
    }
}
