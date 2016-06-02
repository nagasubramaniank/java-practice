// Problem ID: 672. Increment.
//
// Given a base and a number in that base, increment the number by one and print the resulting number in that base only.
//
// Input: First line contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case
// consists of two lines. First line contains an integer B, denoting the base. Second line contains a four-digit number
// N.
//
// Note: {A,B,C,D,E,F} has been used for numbers greater than 9 in any base.
//
// Output: Print the incremented value of the number.
//
// Note: You have to ignore the preceding zeroes in input that are used to make it four-digit. Please see example for
// more details.
//
// Constraints:
// 1 <= T <= 70
// 2 <= B <= 16
// 0000 <= N <= Max value in that base (e.g. 1111 for base 2, FFFF for base 16, etc.)
//
// Example:
//
// Input:
// 3
// 2
// 0010
// 13
// 2139
// 16
// FFFF
//
// Output:
// 11
// 213A
// 10000

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0672_IncrementNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIncrementNumber(in.nextInt(), in.next());
        }
    }

    private static void printIncrementNumber(final int base, final String number) {
        System.out.println(Integer.toString(Integer.parseInt(number, base) + 1, base).toUpperCase());
    }
}
