// Problem ID: 152. Longest Common Subsequence.
//
// Given two sequences, find the length of longest subsequence present in both of them. Both the strings are in
// uppercase.
//
// Input:
// First line contains no of test cases T, for every test case 2 integers are input and then in next two lines, two
// strings of sizes equal to 2 integers respectively are given as a input.
//
// Output:
// Each new line printing length of longest subsequence.
//
// Constraints:
//
// 1 <= T <= 30
// 1 <= size(str1), size(str2) <= 100
//
// Example:
// Input:
// 1
// 6 6
// ABCDGH
// AEDFHR
//
// Output:
// 3
//
// Explanation :
// LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0152_LongestCommonSubsequence {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            // Call next() instead of nextLine() to circumvent with missing EOL characters in geeksforgeeks input file.
            in.next();
            in.next();

            printLongestCommonSubsequence(in.next(), in.next());
        }
    }

    private static void printLongestCommonSubsequence(final String string1, final String string2) {
        int[][] table = new int[string1.length() + 1][string2.length() + 1];

        for (int string1Index = 0; string1Index < string1.length(); string1Index++) {
            for (int string2Index = 0; string2Index < string2.length(); string2Index++) {
                if (string1.charAt(string1Index) == string2.charAt(string2Index)) {
                    table[string1Index + 1][string2Index + 1] = table[string1Index][string2Index] + 1;
                } else {
                    table[string1Index + 1][string2Index + 1] =
                            Math.max(table[string1Index][string2Index + 1], table[string1Index + 1][string2Index]);
                }
            }
        }

        System.out.println(table[string1.length()][string2.length()]);
    }
}
