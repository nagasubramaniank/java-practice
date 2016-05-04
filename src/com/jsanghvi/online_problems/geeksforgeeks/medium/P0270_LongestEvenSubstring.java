// Problem ID: 270. Longest Even Length Substring.
//
// For given string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of the
// substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. Each test case contains a string str of length N.
//
// Output:
//
// Print the length of resultant substring of length 2k such that sum of left k elements is equal to right k elements
// and if there is no such substring print 0.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100
// 0 ≤ k ≤ 100
//
// Example:
//
// Input:
// 2
// 000000
// 1234123
//
// Output:
// 6
// 4

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0270_LongestEvenSubstring {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printEvenSubstringLength(in.next());
        }
    }

    private static void printEvenSubstringLength(final String string) {
        int stringLength = string.length();
        int[] sumTill = new int[string.length() + 1];

        for (int i = 0; i < stringLength; i++) {
            sumTill[i + 1] = sumTill[i] + Character.getNumericValue(string.charAt(i));
        }

        int length;
        for (length = stringLength / 2 * 2; length >= 0; length -= 2) {
            for (int left = 0; left <= stringLength - length; left++) {
                if (sumTill[left] + sumTill[left + length] - 2 * sumTill[left + length / 2] == 0) {
                    System.out.println(length);
                    return;
                }
            }
        }
    }
}
