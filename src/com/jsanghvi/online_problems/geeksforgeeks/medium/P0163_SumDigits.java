// Problem ID: 163. Count of n digit numbers whose sum of digits equals to given sum.
//
// Given two integers ‘n’ and ‘sum’, find count of all n digit numbers with sum of digits as ‘sum’. Leading 0’s are not
// counted as digits. Print your output % 10^9+7.
//
// Input:
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains 2
// integers n and sum.
//
// Output:
// Print the number of digits. Print -1 if answer is not possible.
//
// Constraints:
// 1 <= T <= 30
// 1 <= n <= 100
// 1 <= sum <= 1000
//
// Example:
// Input:
// 1
// 2 2
//
// Output:
// 2

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0163_SumDigits {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNumberCount(in.nextInt(), in.nextInt());
        }
    }

    private static void printNumberCount(final int totalDigits, final int totalSum) {
        final int[][] numberCount = new int[totalDigits + 1][totalSum + 1];

        // numberCount[digits][0] will be 1 for all digits >= 0.
        // numberCount[0][sum] will be 0 for all sum > 0;

        for (int digits = 0; digits <= totalDigits; digits++) {
            numberCount[digits][0] = 1;
        }

        for (int digits = 1; digits <= totalDigits; digits++) {
            for (int sum = 1; sum <= totalSum; sum++) {
                for (int thisDigit = 0; thisDigit <= 9 && sum - thisDigit >= 0; thisDigit++) {
                    numberCount[digits][sum] =
                            (numberCount[digits][sum] + numberCount[digits - 1][sum - thisDigit]) % 1000000007;
                }
            }
        }

        // Subtract count of numbers with leading digit as 0. Make sure that result is non-negative.
        int result = (numberCount[totalDigits][totalSum] - numberCount[totalDigits - 1][totalSum] + 1000000007)
                % 1000000007;
        System.out.println(result != 0 ? result : -1);
    }
}
