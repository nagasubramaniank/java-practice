// Problem ID: 494. Maximum sum increasing subsequence.
//
// Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array
// such that the integers in the subsequence are sorted in increasing order.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N; N is the size of array.
// The second line of each test case contains N input A[].
//
// Output:
// Print the sum of maximum sum sequence of the given array.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 100
// 1 ≤ A[] ≤ 1000
//
// Example:
//
// Input:
// 2
// 7
// 1 101 2 3 100 4 5
// 4
// 10 5 4 3
//
// Output:
// 106
// 10

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0494_MaximumIncreasingSubsequence {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumSumIncreasingSubsequence(A);
        }
    }

    private static void printMaximumSumIncreasingSubsequence(final int[] sequence) {
        int[] maximumSequenceSumTill = new int[sequence.length];
        int maximumSequenceSumAll = 0;

        for (int endIndex = 0; endIndex < sequence.length; endIndex++) {
            maximumSequenceSumTill[endIndex] = sequence[endIndex];

            for (int lastIndex = 0; lastIndex < endIndex; lastIndex++) {
                if (sequence[lastIndex] < sequence[endIndex]
                        && maximumSequenceSumTill[endIndex] < maximumSequenceSumTill[lastIndex] + sequence[endIndex]) {

                    maximumSequenceSumTill[endIndex] = maximumSequenceSumTill[lastIndex] + sequence[endIndex];
                }
            }

            maximumSequenceSumAll = Math.max(maximumSequenceSumAll, maximumSequenceSumTill[endIndex]);
        }

        System.out.println(maximumSequenceSumAll);
    }
}
