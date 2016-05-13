// Problem ID: 186. Large Factorial.
//
// Calculate the factorial for a given number.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, it contains an
// integer 'N'.
//
// Output:
// In each separate line output the answer to the problem.
//
// Constraints:
// 1 <= T <= 101
// 0 <= N <= 100
//
// Example:
// Input:
// 1
// 1
//
// Output:
// 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.math.BigInteger;
import java.util.Scanner;

public class P0186_LargeFactorial {
    public static void main(final String[] args) {
        BigInteger[] factorials = getFactorials(100);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printFactorial(in.nextInt(), factorials);
        }
    }

    private static void printFactorial(final int number, BigInteger[] factorials) {
        System.out.println(factorials[number]);
    }

    private static BigInteger[] getFactorials(final int limit) {
        BigInteger[] factorials = new BigInteger[limit + 1];
        factorials[0] = BigInteger.ONE;

        for (int number = 1; number <= limit; number++) {
            factorials[number] = factorials[number - 1].multiply(BigInteger.valueOf(number));
        }

        return factorials;
    }
}
