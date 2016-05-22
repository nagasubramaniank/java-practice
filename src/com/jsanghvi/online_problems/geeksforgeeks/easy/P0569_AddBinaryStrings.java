// Problem ID: 569. Add binary strings.
//
// Print the resultant string after adding given two binary strings
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case contains two binary strings s1 and s2 separated by space.
//
// Output:
// For each test case print the resultant binary string.
//
// Constraints:
// 1 <= T <= 70
// 1 <= |s1|,|s2| <= 200, where |s| represents the length of string s
//
// Example:
//
// Input:
// 2
// 1101 111
// 10 01
//
// Output:
// 10100
// 11

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0569_AddBinaryStrings {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printAddition(in.next(), in.next());
        }
    }

    private static void printAddition(final String binary1, final String binary2) {
        final int resultLength = Math.max(binary1.length(), binary2.length());
        final StringBuilder output = new StringBuilder(resultLength + 1);

        int carry = 0;
        for (int i = 0; i < resultLength || carry > 0; i++) {
            final int sum = (i < binary1.length() && binary1.charAt(binary1.length() - i - 1) == '1' ? 1 : 0)
                    + (i < binary2.length() && binary2.charAt(binary2.length() - i - 1) == '1' ? 1 : 0) + carry;
            carry = sum / 2;
            output.insert(0, sum % 2);
        }

        System.out.println(output);
    }
}
