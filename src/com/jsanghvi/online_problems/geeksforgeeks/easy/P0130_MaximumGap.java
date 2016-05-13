// Problem ID: 130. Maximum Gap.
//
// Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases.
// Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.
//
// Output:
//
// Print the maximum gap between the successive elements.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 1000
// 1 ≤ A[i] ≤ 1000
//
//
// Example:
//
// Input
// 1
// 3
// 1 10 5
// Output
// 5

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0130_MaximumGap {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumGap(A);
        }
    }

    private static void printMaximumGap(final int[] array) {
        Arrays.sort(array);

        int maximumGap = 0;
        int previousElement = array[0];

        for (final int element : array) {
            maximumGap = Math.max(maximumGap, element - previousElement);
            previousElement = element;
        }

        System.out.println(maximumGap);
    }
}
