// Problem ID: 164. Edit Distance.
//
// Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits
// (operations) required to convert ‘str1′ into ‘str2′.
//
// Insert
// Remove
// Replace
//
// All of the above operations are of cost=1.
// Both the strings are of lowercase.
//
// Input:
// First line contains no of test cases T, for every test case 2 integers are input and then in the next line 2 strings
// of sizes equal to 2 integers respectively are given as a input.
//
// Output:
// For each line minimum number of operations required.
//
// Constraints:
// 1 <= T <= 30
// 1 <= Length(str1) <= 100
// 1 <= Length(str2) <= 100
//
// Example:
// Input:
// 1
// 4 5
// geek gesek
//
// Output:
// 1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0164_EditDistance {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            in.nextInt();
            in.nextInt();

            printEditDistance(in.next(), in.next());
        }
    }

    private static void printEditDistance(final String string1, final String string2) {

    }
}
