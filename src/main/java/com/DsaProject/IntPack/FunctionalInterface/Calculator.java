package com.DsaProject.IntPack.FunctionalInterface;

@FunctionalInterface
public interface Calculator {
    int operate1(int operand1, int operand2);

    default int operate(int operand1, int operand2)
    {
        return operand1 + operand2;
    }
}
