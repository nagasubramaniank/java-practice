// Problem ID: 484. Frobenius coin problem.
//
// Given two coins of denominations “X” and “Y” respectively, find the largest amount that cannot be obtained using
// these two coins (assuming infinite supply of coins) followed by the total number of such non obtainable amounts, if
// no such value exists print “NA”.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// Each test case consist of two integers X and Y in a single line separated by a space.
//
// Output:
// Print an integer which represents largest amount that cannot be obtained using these two coins followed by another
// integer which represents the total number of such non obtainable amounts. If no such value exists print “NA”.
//
// Constraints:
// 1 ≤ T ≤ 70
// 2 ≤ M ≤ 10000
// 2 ≤ N ≤ 10000
//
// Example:
//
// Input:
// 2
// 2 5
// 5 10
//
// Output:
// 3 2
// NA

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0484_CoinProblem {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int M = in.nextInt();
            final int N = in.nextInt();

            printMaximumAmount(M, N);
        }
    }

    private static void printMaximumAmount(final int x, final int y) {
        if (gcd(x, y) != 1) {
            System.out.println("NA");
        } else {
            System.out.println((x * y - (x + y)) + " " + ((x - 1) * (y - 1) / 2));
        }
    }

    private static int gcd(final int x, final int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
