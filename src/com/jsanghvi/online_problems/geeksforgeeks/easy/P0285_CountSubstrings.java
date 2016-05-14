// Problem ID: 285. Count Substrings.
//
// Given a binary string, count number of substrings that start and end with 1. For example, if the input string is
// “00100101”, then there are three substrings “1001”, “100101” and “101”.
//
// Input:
// The first line contains T denoting the number of test cases. Then follows description of test cases.
// Each case contains a string containing 0's and 1's.
//
// Output:
// For each test case, output a single line denoting number of substrings possible.
//
// Constraints:
// 1 <= T <= 100
// 1 <= Length of String <= 100
//
// Example:
// Input:
// 1
// 10101
//
// Output:
// 3

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0285_CountSubstrings {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printSubstringCount(in.next());
        }
    }

    private static void printSubstringCount(final String binaryString) {
        int countOnes = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                countOnes += 1;
            }
        }

        System.out.println(countOnes * (countOnes - 1) / 2);
    }
}
