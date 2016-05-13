// Problem ID: 187. Trailing zeroes in factorial.
//
// For an integer n find number of trailing zeroes in n! .
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, it contains an
// integer 'N'.
//
// Output:
// In each separate line output the answer to the problem.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 1000
//
// Example:
// Input:
// 1
// 9
//
// Output:
// 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0187_FactorialTrailingZeroes {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printTrailingZeroes(in.nextInt());
        }
    }

    private static void printTrailingZeroes(final int number) {
        int trailingZeroes = 0;
        for (int divisor = 5; divisor <= number; divisor *= 5) {
            trailingZeroes += number / divisor;
        }

        System.out.println(trailingZeroes);
    }
}
