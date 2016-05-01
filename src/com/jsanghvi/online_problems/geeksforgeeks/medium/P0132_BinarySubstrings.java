// Problem ID: 132. Binary String.
//
// Given a binary string, count number of substrings that start and end with 1. For example, if the input string is
// “00100101”, then there are three substrings “1001”, “100101” and “101”.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. Each test case consist of an integer
// 'n' denoting the string length and next line is followed by a binary string .
//
// Output:
//
// Print the number of substring starting and ending with 1 in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 40
// 1 ≤ |s| ≤ 1000
//
// Example:
//
// Input:
// 1
// 4
// 1111
//
// Output:
// 6


package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0132_BinarySubstrings {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        in.nextLine();

        for (int test = 0; test < T; test++) {
            in.nextLine();
            printBinarySubstrings(in.nextLine());
        }
    }

    private static void printBinarySubstrings(final String string) {
        int countOnes = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                countOnes += 1;
            }
        }

        System.out.println((countOnes * (countOnes - 1) / 2));
    }
}
