/*
 * Problem: Insertion Sort
 * Difficulty: Easy
 * Source: Striver's SDE Sheet - Sorting Algorithms
 *
 * Problem Statement:
 * Given an array of integers, sort it in-place in ascending order using the Insertion
 * Sort algorithm. Insertion sort iterates through the array, and for each element picks
 * it out and inserts it into its correct position among the already-sorted portion to
 * its left by shifting larger elements one step to the right.
 *
 * Approach:
 * Start from index 1. For each element (key), compare it backwards with already-sorted
 * elements. Shift each larger element one position right to make space, then place the
 * key in the correct slot. Best case O(n) when array is already sorted (no shifts needed).
 * Stable sort — equal elements preserve their original relative order.
 *
 * Time Complexity: O(n^2) worst/average case, O(n) best case (already sorted)
 * Space Complexity: O(1) — in-place sort
 */
import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j   = i - 1;

            // Shift elements greater than key one position to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key in its correct sorted position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        InsertionSort sol = new InsertionSort();

        int[] arr1 = {5, 3, 1, 4, 2};
        sol.insertionSort(arr1);
        System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 4, 5]

        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        sol.insertionSort(arr2);
        System.out.println(Arrays.toString(arr2)); // [11, 12, 22, 25, 34, 64, 90]

        int[] arr3 = {1, 2, 3, 4, 5};             // already sorted — O(n) best case
        sol.insertionSort(arr3);
        System.out.println(Arrays.toString(arr3)); // [1, 2, 3, 4, 5]

        int[] arr4 = {5, 4, 3, 2, 1};             // reverse sorted — worst case
        sol.insertionSort(arr4);
        System.out.println(Arrays.toString(arr4)); // [1, 2, 3, 4, 5]
    }
}
