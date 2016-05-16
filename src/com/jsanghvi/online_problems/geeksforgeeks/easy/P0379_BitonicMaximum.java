// Problem ID: 379. Maximum value in a bitonic array.
//
// Given an array of elements which is first increasing and then decreasing, find the maximum element in the array.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N, the size of array
// The second line of each test case contains N integers which are the array elements.
//
// Output:
// Print the maximum element in the array.
//
// Constraints:
// 1 ≤ T ≤ 50
// 3 ≤ N ≤ 100
// 1 ≤ a[i] ≤ 100000
//
// Example:
//
// Input
// 2
// 9
// 1 15 25 45 42 21 17 12 11
// 5
// 1 45 47 50 5
//
// Output
// 45
// 50


package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0379_BitonicMaximum {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N + 1];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            A[N] = Integer.MIN_VALUE;

            printBitonicMaximum(A);
        }
    }

    private static void printBitonicMaximum(final int[] array) {
        for (int left = 0, right = array.length - 1; left <= right; ) {
            final int mid = ((left + right) / 2);
            if (mid != left && array[mid - 1] > array[mid]) {
                right = mid - 1;
            } else if (mid != right && array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                System.out.println(array[mid]);
                return;
            }
        }
    }
}
