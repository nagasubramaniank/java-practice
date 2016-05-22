// Problem ID: 567. Maximum Difference.
//
// Given an array C[] of integers, find out the maximum difference between any two elements such that larger element
// appears after the smaller number in C[].
//
// Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is
// [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9).
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input C[i].
//
// Output:
// Print the maximum difference between two element. Otherwise print -1
//
// Constraints:
// 1 ≤ T ≤ 80
// 2 ≤ N ≤ 100
// 1 ≤ C[i] ≤ 500
//
// Example:
//
// Input:
// 2
// 7
// 2 3 10 6 4 8 1
// 5
// 1 2 90 10 110
//
// Output:
// 8
// 109

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0567_MaximumDifference {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumDifference(A);
        }
    }

    private static void printMaximumDifference(final int[] numbers) {
        int maximumDifference = -1;
        int smallestVisitedElement = 1000;

        for (final int number : numbers) {
            maximumDifference = Math.max(maximumDifference, number - smallestVisitedElement);
            smallestVisitedElement = Math.min(smallestVisitedElement, number);
        }

        System.out.println(maximumDifference);
    }
}
