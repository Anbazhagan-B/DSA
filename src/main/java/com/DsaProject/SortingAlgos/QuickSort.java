package com.DsaProject.SortingAlgos;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right)
        {
            while (left <= right && arr[left] < pivot)
            {
                left++;
            }

            while (left <= right && arr[right] > pivot)
            {
                right--;
            }

            if(left <= right)
            {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        swap(arr, low ,right);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
