// Problem ID: 106. Kadane's Algorithm.
//
// Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. The first line of each test case contains a single integer N denoting the size of array. The second line
// contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
// Output:
// Print the maximum sum of the contiguous sub-array in a separate line for each test case.
//
// Constraints:
// 1 ≤ T ≤ 40
// 1 ≤ N ≤ 100
// -100 ≤ A[i] <= 100
//
// Example:
// Input
// 2
// 3
// 1 2 3
// 4
// -1 -2 -3 -4
//
// Output
// 6
// -1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0106_KadanesAlgorithm {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumSubsequenceSum(A);
        }
    }

    private static void printMaximumSubsequenceSum(int[] sequence) {
        int maximumSumTill = Integer.MIN_VALUE;
        int maximumSumAll = Integer.MIN_VALUE;

        for (int number : sequence) {
            maximumSumTill = Math.max(maximumSumTill, 0) + number;
            maximumSumAll = Math.max(maximumSumAll, maximumSumTill);
        }

        System.out.println(maximumSumAll);
    }
}
