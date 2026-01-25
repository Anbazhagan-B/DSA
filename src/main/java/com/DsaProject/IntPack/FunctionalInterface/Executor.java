package com.DsaProject.IntPack.FunctionalInterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
        System.out.println(groupByLength(List.of("ab", "aa", "bb", "fvg", "ttt", "c")));
    }

    Map<Integer, List<String>> groupByLength(List<String> strs)
    {
        return strs.stream().collect(Collectors.groupingBy(String::length));
    }

    List<Integer> countDistinctElements(List<Integer> nums)
    {
        return nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).toList();
    }

    Map<Integer, List<String>> groupWordsByLength(List<String> strs)
    {
        return strs.stream().collect(Collectors.groupingBy(String::length));
    }

    List<Character> findAlDuplicate(String str)
    {
        return str.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).toList();
    }
    long countWordsInString(String str)
    {
        return Arrays.stream(str.split(" ")).count();
    }

    List<String> convertToUpperCase(List<String> strs)
    {
        return strs.stream().map(String::toUpperCase).toList();
    }

    String joinByComma(List<String> strs)
    {
        return strs.stream().collect(Collectors.joining(","));
    }

    Map<String, Long> WordWithLength(List<String> strs)
    {
        return strs.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    List<String> filterStringByJ(List<String> strs)
    {
        return strs.stream().filter(str -> str.startsWith("J")).toList();
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

    public long vowelsCount(String str)
    {
        String vowels = "aeiouAEIOU";

        return str.chars().filter(ch -> vowels.indexOf((char)ch) != -1).count();
    }

    String convertStringToUpperCase(String str)
    {
        return str.chars().mapToObj(ch -> Character.toUpperCase((char)ch)).map(String::valueOf).collect(Collectors.joining());
    }

    long totalCharCount(String str)
    {
        return str.chars().count();
    }
}
