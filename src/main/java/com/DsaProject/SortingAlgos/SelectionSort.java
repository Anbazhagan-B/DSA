package com.DsaProject.SortingAlgos;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args)
    {
        int[] arr = new int[]{4, 2, 7, 5, 9, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap arr[i] with arr[minIdx]
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }


    }
}
