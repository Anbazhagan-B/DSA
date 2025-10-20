package com.DsaProject.Prods;

import java.util.*;

public class Client {

    //
    //Employee -> id, name, salary;

    // select name from (select * from employee order by salary desc limit 3)

    public static void main(String[] args) {

        int[] arr = new int[ ]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 12;
        System.out.println(tripletSum(arr));
    }

    // triplet sum with index
    static List<Integer> tripletSum(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                for(int k = j + 1; k < n; k++)
                {
                    if(arr[i] + arr[j] + arr[k] == 12)
                    {
                        return List.of(i, j, k);
                    }
                }
            }
        }

        return new ArrayList<>();
    }

}
