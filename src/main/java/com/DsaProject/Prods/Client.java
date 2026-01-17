package com.DsaProject.Prods;

import com.DsaProject.LLD.PubSubLLD.Publisher;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        System.out.println(charWithCount("AAbbcccc"));
    }

    static Map<Character, Long> charWithCount(String str)
    {
        return  str.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}

