// Problem ID: 647. Subsequence matching.
//
// Given an all upper case string, check if it is a combination of one of the following:
// 1. R
// 2. RY
// 3. RYY
//
// Input:
//
// First line contains an integer T denoting the number of test cases. Each of the following T lines will contain an
// upper case string.
//
// Output:
//
// Print YES if the sequence is correct, NO if not correct.
//
// Constraints:
//
// 1 <= T <= 1000
// 1 <= 10^5 <= Size of String
//
// Example:
//
// Input:
// 3
// RY
// RWR
// RRYY
//
// Output:
// YES
// NO
// YES

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0647_SubsequenceMatching {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsSubsequenceMatching(in.next());
        }
    }

    private static void printIsSubsequenceMatching(final String string) {
        int countY = 2;

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            countY = character == 'Y' ? countY + 1 : 0;

            if (countY > 2 || (character != 'R' && character != 'Y')) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
