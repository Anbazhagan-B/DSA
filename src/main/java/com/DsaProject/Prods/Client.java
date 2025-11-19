package com.DsaProject.Prods;

import java.util.*;
import java.util.stream.Collectors;

public class Client {


    public static void main(String[] args) {
        System.out.println(firstNonRepeatingWithStream("abCdabc"));
        //System.out.println(findNumbersStartWithOne(List.of(10,15,8,49,25,98,32)));
    }

    public static char firstNonRepeatingWithStream(String input)
    {
       // return  (char)input.chars().boxed().collect(Collectors.groupingBy()).findFirst().getAsInt();

        Map<Character, Integer> charsWithCount = new LinkedHashMap<>();

        for (Character character: input.toCharArray())
        {
            charsWithCount.put(Character.toLowerCase(character), charsWithCount.getOrDefault(character, 0) + 1);
        }

        return charsWithCount.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();

    }
///  List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);

    static List<String> findNumbersStartWithOne(List<Integer> nums)
    {
        return nums.stream().map(num -> num.toString()).filter(num -> num.startsWith("1")).toList();
    }
}
