// Problem ID: 235. Repetitive Addition of Digits.
//
// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//
// Input:
// The first line contains 'T' denoting the number of test cases. Then follows description of test cases. The next T
// lines contains a single integer N denoting the value of N.
//
// Output:
// Output the sum of all its digit until the result has only one digit.
//
// Constraints:
// 1 <= T <= 30
// 1 <= n <= 10^9
//
// Example:
//
// Input:
// 2
// 1
// 98
//
// Output:
// 1
// 8
//
// Explanation:
// For example, if we consider 98, we get 9+8=17 after first addition. Then we get 1+7=8. We stop at this point because
// we are left with one digit.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0235_DigitAddition {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printDigitAddition(in.nextInt());
        }
    }

    private static void printDigitAddition(final int number) {
        System.out.println(number % 9);
    }
}
