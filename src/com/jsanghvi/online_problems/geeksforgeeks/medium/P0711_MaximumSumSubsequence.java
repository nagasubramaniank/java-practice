// Problem ID: 711. Maximum sum subsequence.
//
// Given an array sequence [A1 , A2, ..., An], the task is to find the maximum possible sum of increasing subsequence S
// of length K such that Si1 <= Si2 <= Si3 <= .... <= Sin.
//
// Input:
// The first line contains an integer 'T' denoting the number of test cases. Then 'T' test cases follows. Each test case
// consists of two line containing two space separated integers 'N' and 'K' denoting the size of the array and length of
// the subsequence.
//
// Output:
// Print the maximum possible sum. If their is no subsequence of length K print "-1".
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 1 <= a[i] <= 10^5
// 1 <= k <= 100
//
// Example:
//
// Input
// 1
// 8 3
// 8 5 9 10 5 6 19 8
//
// Output
// 38

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0711_MaximumSumSubsequence {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int K = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumSumIncreasingSubsequence(A, K);
        }
    }

    private static void printMaximumSumIncreasingSubsequence(final int[] sequence, final int requiredLength) {
        int[][] maximumSumEndLengths = new int[sequence.length][requiredLength + 1];

        for (int endIndex = 0; endIndex < sequence.length; endIndex++) {
            maximumSumEndLengths[endIndex][1] = sequence[endIndex];

            for (int length = 2; length <= requiredLength; length++) {
                maximumSumEndLengths[endIndex][length] = -1;

                for (int lastIndex = 0; lastIndex < endIndex; lastIndex++) {
                    if (maximumSumEndLengths[lastIndex][length - 1] != -1
                            && sequence[lastIndex] <= sequence[endIndex]) {

                        maximumSumEndLengths[endIndex][length] = Math.max(maximumSumEndLengths[endIndex][length],
                                sequence[endIndex] + maximumSumEndLengths[lastIndex][length - 1]);
                    }
                }
            }
        }

        int maximumSumAll = -1;
        for (int endIndex = 0; endIndex < sequence.length; endIndex++) {
            maximumSumAll = Math.max(maximumSumAll, maximumSumEndLengths[endIndex][requiredLength]);
        }

        System.out.println(maximumSumAll);
    }
}
