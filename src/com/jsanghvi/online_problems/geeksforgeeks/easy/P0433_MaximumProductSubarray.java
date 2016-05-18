// Problem ID: 433. Maximum product subarray.
//
// Given an array that contains both positive and negative integers, find the product of the maximum product subarray.
//
// Assumption: There is always a positive product possible, i.e., no array of this form: {0, -20, 0, 0} or {-20}.
//
// Input:
// First line of input contain number of test cases T. First line of test case contain the size of array and second line
// of test case contain the array elements.
//
// Output:
// Maximum product of subarray is displayed to the user.
//
// Constraints:
// 1 <= T <= 50
// 1 <= N <= 9
// -10 <= arr[i] <= 10
//
// Example:
//
// Input:
//
// 3
// 5
// 6 -3 -10 0 2
// 6
// 2 3 4 5 -1 0
// 10
// 8 -2 -2 0 8 0 -6 -8 -6 -1
//
// Output:
// 180
// 120
// 288

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0433_MaximumProductSubarray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N + 1];

            // Have element 0 as last element to simplify algorithm.
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumProduct(A);
        }
    }

    private static void printMaximumProduct(final int[] numbers) {
        int maximumProduct = 0;

        for (int left = 0; left < numbers.length; left++) {
            int product = 1;
            for (int right = left; right < numbers.length; right++) {
                product *= numbers[right];
                maximumProduct = Math.max(maximumProduct, product);
            }
        }

        System.out.println(maximumProduct);
    }
}
