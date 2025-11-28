package com.DsaProject.IntPack.FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {

    public void execute()
    {
        List<String> names = Arrays.asList("john", "KK");

        Map<String, Integer> map = names.stream().collect(Collectors.toMap(name -> name, String::length));
        System.out.println(map);
    }
}
