// Problem ID: 168. nCr.
//
// Find nCr for given n and r.
//
// Input:
// First line contains no of test cases T, for every test case 2 integers as inputs (n,r).
//
// Output:
// Compute and print the value in separate line. Modulus your output to 10^9+7.
//
// Constraints:
// 1 <= T <= 50
// 1 <= n <= 1000
// 1 <= r <= 800
//
// Example:
// Input:
// 1
// 3 2
//
// Output:
// 3

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0168_NChooseR {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNChooseR(in.nextInt(), in.nextInt());
        }
    }

    private static void printNChooseR(final int N, final int R) {

    }
}
