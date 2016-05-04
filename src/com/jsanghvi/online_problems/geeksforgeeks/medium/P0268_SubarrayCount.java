// Problem ID: 268. Count of Subarrays.
//
// Given an array of N positive integers  a1, a2, ..., an. The value of each contiguous subarray in given array is the
// maximum element present in that subarray. Return the number of subarrays having value strictly greater than K.
//
// Input:
//
// The first line of the input contains 'T' denoting the total number of test cases.Then follows the description of test
// cases. The first line of each test case contains two space separated positive integers N and K denoting the size of
// array and the value of K. The second line contains N space separated positive integers denoting the elements of
// array.
//
// Output:
//
// Output the number of subarrays having value strictly greater than K.
//
// Constraints:
//
// 1 <= T <= 50
// 1 <= N <= 100
// 1 <= a[i] <= 10^5
//
// Example:
//
// Input:
// 2
// 3 2
// 3 2 1
// 4 1
// 1 2 3 4
//
// Output:
// 3
// 9

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0268_SubarrayCount {
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

            printSubarrayCount(A, K);
        }
    }

    private static void printSubarrayCount(final int[] array, final int greaterThan) {

        int count = 0;
        int startPosition = -1, endPosition = array.length;

        for (int position = 0; position < endPosition; position++) {
            if (array[position] > greaterThan) {
                count += (position - startPosition) * (endPosition - position);
                startPosition = position;
            }
        }

        System.out.println(count);
    }
}
