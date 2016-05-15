// Problem ID: 300. Strong Number.
//
// Write a program to check whether a number is strong or not. A number is called strong number if sum of the factorials
// of its digits is equal to number itself. For example: 145 as 1! + 4! + 5! = 1 + 24 + 120 = 145
//
// Input:
// First line contains number of test cases T. Then following T lines contains an integer N.
//
// Output:
// Output "Strong" if given number is strong else "Not Strong" .
//
// Constraints:
// 1 <= T <= 50
// 0 <= N <= 1000
//
// Example:
// Input:
// 2
// 145
// 10
//
// Output:
// Strong
// Not Strong

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0300_StrongNumber {
    public static void main(final String[] args) {
        int[] factorials = getFactorials(9);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsStrongNumber(in.nextInt(), factorials);
        }
    }

    private static void printIsStrongNumber(final int number, final int[] factorials) {
        int sumDigitFactorials = 0;
        for (int remainingNumber = number; remainingNumber > 0; remainingNumber /= 10) {
            sumDigitFactorials += factorials[remainingNumber % 10];
        }

        System.out.println(sumDigitFactorials == number ? "Strong" : "Not Strong");
    }

    private static int[] getFactorials(final int limit) {
        final int[] factorials = new int[limit + 1];
        factorials[0] = 1;

        for (int i = 1; i <= limit; i++) {
            factorials[i] = i * factorials[i - 1];
        }

        return factorials;
    }
}
