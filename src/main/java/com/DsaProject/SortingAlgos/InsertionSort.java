package com.DsaProject.SortingAlgos;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 6, 5, 3, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at the right position
            arr[j + 1] = key;
        }
    }
}
