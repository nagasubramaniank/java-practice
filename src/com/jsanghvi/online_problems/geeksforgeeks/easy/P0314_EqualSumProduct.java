// Problem ID: 314. Equal Sum and Product.
//
// Given an array, return the count of number of contiguous subarrays for which the sum and product of elements are
// equal.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. T test cases follow. The first line
// of each test contains the integer N. The next line contains N integers — A1, A2, ..., AN — denoting the array.
//
// Output:
// For each test case, output a single line containing the answer.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10
// 1 <= A[i] <= 10 (1 <= i <= N)
//
// Example:
//
// Input:
// 1
// 5
// 1 2 3 4 5
//
// Output:
// 6
//
// Explanation:
//
// In the sample test case, all 6 subarrays having sum of elements equals to the product of elements are:
// {1}, {2}, {3}, {4}, {5}, {1,2,3}

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0314_EqualSumProduct {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printEqualSumProducts(A);
        }
    }

    private static void printEqualSumProducts(final int[] numbers) {
        int equalSumProducts = 0;

        for (int start = 0; start < numbers.length; start++) {
            int sum = 0;
            int product = 1;

            for (int end = start; end < numbers.length; end++) {
                sum += numbers[end];
                product *= numbers[end];

                if (sum == product) {
                    equalSumProducts += 1;
                }
            }
        }

        System.out.println(equalSumProducts);
    }
}
