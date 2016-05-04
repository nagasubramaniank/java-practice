// Problem ID: 252. Consecutive 1's not allowed.
//
// Count number of binary strings without consecutive 1’s
//
// Problem Description:
// Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive
// 1’s. Output your answer mod 10^9 + 7.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. Each test case contain an integer N representing length of the binary string.
//
// Output:
// Print the count number of binary strings without consecutive 1’s of length N.
//
// Constraints:
// 1 ≤ T ≤ 10
// 1 ≤ N ≤ 70
//
// Example:
// Input:
// 2
// 3
// 2
//
// Output:
// 5
// 3
//
// Explanation:
// For first test case 5 strings are (000, 001, 010, 100, 101)
// For second test case 3 strings are (00, 01, 10)

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0252_ConsecutiveOnes {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNumberOfStrings(in.nextInt());
        }
    }

    private static void printNumberOfStrings(final int length) {

        // Let number of strings of length k that end with 1 be F(k, 1).
        // Let number of strings of length k that do not end with 1 be F(k, 0).
        // Then F(k, 0) = F(k-1, 0) + F(k-1, 1) and F(k, 1) = F(k-1, 0)
        // From above two equations, F(k, 0) = F(k-1, 0) + F(k-2, 0)
        // We need to find F(length, 0) + F(length, 1) which is same as F(length+1, 0)
        // Initial condition, F(0, 0) = 1 (empty set does not end with a 1), F(1, 0) = 1.

        int result = 0;
        for (int i = 0, previous1 = 0, previous2; i <= length + 1; i++) {
            previous2 = previous1;
            previous1 = result;
            result = i <= 1 ? 1 : (previous1 + previous2) % 1000000007;
        }

        System.out.println(result);
    }
}
