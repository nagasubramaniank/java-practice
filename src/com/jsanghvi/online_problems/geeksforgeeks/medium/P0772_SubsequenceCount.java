// Problem ID: 772. Jumbled strings.
//
// You are provided an input string S and the string “GEEKS” . Can you figure out all possible subsequence “GEEKS” in
// the string S ? You have to tell the number of ways in which the subsequence “GEEKS” can be formed from the string S.
//
// Input:
// The first line of input contains a single integer T, denoting the number of test cases. Then T test cases follow.
// Each test case consists of two lines. The first line of each test case contains an integer N denoting the size of the
// string S. Second line of each test case consists of a string S of size N.
//
// Output:
// Corresponding to each test case, print in a new line, a number denoting the number of ways in which we can form the
// subsequence "GEEKS". Output the answer modulo 1000000007.
//
// Constraints :
// 1<=T<=10
// 1<=N<=500
// Input String contains only uppercase English Letters
//
// Examples:
// Input
// 2
// 5
// GEEKS
// 8
// AGEEKKSB
//
// Output :
// 1
// 2
//
// Explanation :
// In the first test case the input string is GEEKS itself so the number of ways is 1.
// For the second case there are two K's. So a total of two possible strings can be formed by taking either of the two K's.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0772_SubsequenceCount {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printSubsequenceCount(in.nextInt(), in.next());
        }
    }

    private static void printSubsequenceCount(final int length, final String string) {
        char[] sequence = string.substring(0, length).toCharArray();
        char[] subsequence = new char[]{'G', 'E', 'E', 'K', 'S'};

        int[][] subsequenceCounts = new int[sequence.length + 1][subsequence.length + 1];

        // Subsequence count for a string is equal to the subsequence count of same string without the last character
        // plus, if last character in string is same as last character in subsequence, then subsequence count for
        // string without last character and subsequence without last character.

        for (int i = 0; i <= sequence.length; i++) {
            for (int j = 0; j <= subsequence.length; j++) {
                if (j == 0) {
                    subsequenceCounts[i][j] = 1;
                } else if (i == 0) {
                    subsequenceCounts[i][j] = 0;
                } else {
                    subsequenceCounts[i][j] = (subsequenceCounts[i - 1][j]
                            + (sequence[i - 1] == subsequence[j - 1] ? subsequenceCounts[i - 1][j - 1] : 0))
                            % 1000000007;
                }
            }
        }

        System.out.println(subsequenceCounts[sequence.length][subsequence.length]);
    }
}
