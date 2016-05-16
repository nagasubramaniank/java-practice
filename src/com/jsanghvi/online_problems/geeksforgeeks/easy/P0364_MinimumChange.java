// Problem ID: 354. Number of Coins.
//
// Given a value V, if we want to make change for V cents,
// and we have infinite supply of each of C = { C1, C2, .., Cm } valued coins,
// what is the minimum number of coins to make the change?
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is V and N, V is the value of cents and N is the number of coins.
// The second line of each test case contains N input C[i],value of available coins.
//
// Output:
// Print the minimum number of coins to make the change, if not possible print -1.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ V ≤ 10000
// 1 ≤ N ≤ 50
// 1 ≤ C[i] ≤ 100
//
// Example:
// Input
// 1
// 7 2
// 2 1
//
// Output
// 4

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0364_MinimumChange {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int V = in.nextInt();
            final int N = in.nextInt();
            final int[] C = new int[N];

            for (int i = 0; i < N; i++) {
                C[i] = in.nextInt();
            }

            printMinimumChange(C, V);
        }
    }

    private static void printMinimumChange(final int[] coins, final int value) {
        final int[] minimumChange = new int[value + 1];
        minimumChange[0] = 0;

        for (int requiredValue = 1; requiredValue <= value; requiredValue++) {
            minimumChange[requiredValue] = Integer.MAX_VALUE / 2;

            for (final int coinValue : coins) {
                if (requiredValue >= coinValue
                        && minimumChange[requiredValue] > minimumChange[requiredValue - coinValue] + 1) {
                    minimumChange[requiredValue] = minimumChange[requiredValue - coinValue] + 1;
                }
            }
        }

        System.out.println(minimumChange[value] == Integer.MAX_VALUE / 2 ? -1 : minimumChange[value]);
    }
}
