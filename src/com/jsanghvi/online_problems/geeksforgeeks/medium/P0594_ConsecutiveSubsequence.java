// Problem ID: 594. Longest Consecutive Subsequence.
//
// Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are
// consecutive integers, the consecutive numbers can be in any order.
//
// Input:
//
// The first line of input contains T, number of test cases.
// First line of line each test case contains a single integer N.
// Next line contains N integer array.
//
// Output:
//
// Print the output of each test case in a separate line.
//
// Constraints:
//
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= a[i] <= 500
//
// Example:
//
// Input:
// 2
// 7
// 2 6 1 9 4 5 3
// 7
// 1 9 3 10 4 20 2
//
// Output:
// 6
// 4

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0594_ConsecutiveSubsequence {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printLongestSubsequence(A);
        }
    }

    private static void printLongestSubsequence(final int array[]) {
        final boolean[] numberPresent = new boolean[501];
        for (int number : array) {
            numberPresent[number] = true;
        }

        int longestLength = 0, length = 0;
        for (boolean present : numberPresent) {
            if (present) {
                length += 1;
                longestLength = Math.max(longestLength, length);
            } else {
                length = 0;
            }
        }

        System.out.println(longestLength);
    }
}
