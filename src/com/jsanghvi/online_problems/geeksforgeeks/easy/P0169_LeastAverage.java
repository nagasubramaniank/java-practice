// Problem ID: 169. Subarray with least average.
//
// Find the subarray with least average of size K. Given an array arr[] of size n and integer k such that k <= n.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' and 'K' denoting the size of array. The second line contains N space-separated integers
// A1, A2, ..., AN denoting the elements of the array.
//
// Output:
// The first and last index of the subarray. (Index begins from 1).
//
// Constraints:
// 1 <= T <= 30
// 1 <= N <= 1000
// 1 <= K <= N
// 1 <= A[i] <= 103
//
// Example:
// Input:
// 1
// 3 1
// 30 20 10
//
// Output:
// 3 3

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0169_LeastAverage {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int K = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printLeastAverageSubarray(A, K);
        }
    }

    private static void printLeastAverageSubarray(final int[] array, final int size) {

        int sum = 0;
        for (int index = 0; index < size; index++) {
            sum += array[index];
        }

        int minimumSum = sum;
        int minimumSumIndex = 0;
        for (int index = 1; index < array.length - size + 1; index++) {
            sum += array[index + size - 1] - array[index - 1];

            if (minimumSum > sum) {
                minimumSum = sum;
                minimumSumIndex = index;
            }
        }

        System.out.println((minimumSumIndex + 1) + " " + (minimumSumIndex + size));
    }
}
