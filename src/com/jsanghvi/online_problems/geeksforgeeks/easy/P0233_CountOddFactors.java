// Problem ID: 233. Count Odd Factors.
//
// Given an integer N, return  count of numbers having odd number of factors from 1 to N inclusive.
//
// Input:
// The first line contains T denoting the number of test cases. Then the following T lines contains the single integer N
// denoting the value of N.
//
// Output:
// Output the total number of numbers having odd number of factors.
//
// Constraints:
// 1 <= T <= 30
// 1 <= N <= 10^9
//
// Example:
//
// Input:
// 2
// 1
// 5
//
// Output:
// 1
// 2

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0233_CountOddFactors {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printOddFactorsCount(in.nextInt());
        }
    }

    private static void printOddFactorsCount(final int number) {
        System.out.println((new Double(Math.sqrt(number))).intValue());
    }
}
