// Problem ID: 221. Minimum number of coins.
//
// Given a value N, if we want to make change for N Rs, and we have infinite supply of each of the denominations in
// Indian currency, i.e., we have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes. Find the
// minimum number of coins and/or notes needed to make the change.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// Each test case consist of an Integer value N denoting the amount to get change for.
//
// Output:
//
// Print all the possible denominations needed to make the change in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 2000
//
// Example:
//
// Input
// 1
// 43
//
// Output
// 20 20 2 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0221_MinimumCoins {
    private final static int[] denominations = new int[]{1000, 500, 100, 50, 20, 10, 5, 2, 1};

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printMinimumCoins(in.nextInt());
        }
    }

    private static void printMinimumCoins(final int amount) {

        int minimumCoins = 0;
        int remainingAmount = amount;
        StringBuilder output = new StringBuilder();

        for (int denomination : denominations) {
            for (; remainingAmount >= denomination; remainingAmount -= denomination) {
                output.append(denomination).append(' ');
            }
        }

        System.out.println(output);
    }
}
