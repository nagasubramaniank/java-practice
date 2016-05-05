// Problem ID: 290. String formation from substring.
//
// Given a string ‘str’, check if it can be constructed by taking a substring of it and appending multiple copies of the
// substring together.  For example "abab" can be created by appending "ab" to "ab", but "abac" cannot be created by
// appending a substring to itself.
//
// Input:
// The first line contains T denoting the number of test cases. Then follows description of test cases. Each case
// contains a string.
//
// Output:
// For each test case, output "True" if it is possible and "False" if not.
//
// Constraints:
// 1 <= T <= 50
// 1 <= Length of String <= 1000
//
// Example:
// Input:
// 1
// abcabcabc
//
// Output:
// True
//
// Explanation :
// The given string is 3 times repetition of "abc"

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0290_StringFormation {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printStringContainsRepetitions(in.next());
        }
    }

    private static void printStringContainsRepetitions(final String string) {

        // Apply the algorithm to find longest prefix-suffix of the string.
        final int[] longestPrefixSuffix = new int[string.length()];
        int longestPrefix = 0;

        for (int i = 1; i < longestPrefixSuffix.length; ) {
            if (string.charAt(i) == string.charAt(longestPrefix)) {
                longestPrefix += 1;
                longestPrefixSuffix[i++] = longestPrefix;
            } else if (longestPrefix == 0) {
                longestPrefixSuffix[i++] = 0;
            } else {
                longestPrefix = longestPrefixSuffix[longestPrefix - 1];
            }
        }

        System.out.println(longestPrefix > 0 && longestPrefix % (string.length() - longestPrefix) == 0 ?
                "True" : "False");
    }
}
