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

import java.math.BigInteger;
import java.util.Scanner;

public class P0168_NChooseR {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNChooseR(in.nextInt(), in.nextInt());
        }
    }

    private static void printNChooseR(final int N, int R) {

        if (R > N) {
            System.out.println(0);
            return;
        }

        R = Math.min(R, N - R);

        BigInteger result = BigInteger.ONE;
        for (int r = 0; r < R; r++) {
            result = result.multiply(BigInteger.valueOf(N - r)).divide(BigInteger.valueOf(r + 1));
        }

        System.out.println(result.mod(BigInteger.valueOf(1000000007)));
    }
}
