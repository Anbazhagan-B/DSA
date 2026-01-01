package com.DsaProject.Prods;

import com.DsaProject.LLD.PubSubLLD.Publisher;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        System.out.println(fistNonRepeatingNum(List.of(4, 5, 1, 2, 3, 1, 4, 5)));
    }

    // Given an integer array, find the first non-repeating element.
    //Input:
    //[4, 5, 1, 2, 1, 4, 5]
    //Output:
    //2

    static int fistNonRepeatingNum(List<Integer> nums)
    {
        return nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1).skip(1).findFirst().get().getKey();
    }
}

