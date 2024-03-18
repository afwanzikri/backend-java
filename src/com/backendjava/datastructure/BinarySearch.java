package com.backendjava.datastructure;

import java.util.Arrays;

public class BinarySearch {
    // Iterative implementation of binary search
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target)
                return mid;
            else if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // If target is not found, return -1
        return -1;
    }

    // Recursive implementation of binary search
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target)
                return mid;
            else if (array[mid] < target)
                return binarySearchRecursive(array, target, mid + 1, right);
            else
                return binarySearchRecursive(array, target, left, mid - 1);
        }

        // If target is not found, return -1
        return -1;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 91;

        // Sorting the array
        Arrays.sort(sortedArray);

        // Printing the sorted array
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));

        // Using iterative binary search
        int index = binarySearch(sortedArray, target);
        if (index != -1)
            System.out.println("Iterative Binary Search: Element found at index " + index);
        else
            System.out.println("Iterative Binary Search: Element not found");

        // Using recursive binary search
        index = binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1);
        if (index != -1)
            System.out.println("Recursive Binary Search: Element found at index " + index);
        else
            System.out.println("Recursive Binary Search: Element not found");
    }
}
