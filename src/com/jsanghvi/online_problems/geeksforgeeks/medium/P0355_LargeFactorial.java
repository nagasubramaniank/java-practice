// Problem ID: 355. Factorial of large numbers.
//
// Given an integer, the task is to find factorial of the number.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,the number whose factorial is to be found.
//
// Output:
// Print the factorial of the number in separate line.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 1000
//
// Example:
// Input
// 3
// 5
// 10
// 2
//
// Output
// 120
// 3628800
// 2

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.math.BigInteger;
import java.util.Scanner;

public class P0355_LargeFactorial {
    public static void main(final String[] args) {
        final BigInteger[] factorials = getFactorials(1000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printFactorial(in.nextInt(), factorials);
        }
    }

    private static void printFactorial(final int number, final BigInteger[] factorials) {
        System.out.println(factorials[number]);
    }

    private static BigInteger[] getFactorials(final int upTo) {
        final BigInteger[] factorials = new BigInteger[upTo + 1];
        factorials[0] = BigInteger.ONE;

        for (int number = 1; number <= upTo; number++) {
            factorials[number] = factorials[number - 1].multiply(BigInteger.valueOf(number));
        }

        return factorials;
    }
}
