// Problem ID: 89. Minimum Change.
//
// Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of
// S = { S1, S2, .. , Sm} valued coins. The order of coins does not matter. For example, for N = 4 and S = {1,2,3},
// there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
// there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
//
// Input:
//
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'M' denoting the size of array. The second line contains M space-separated integers
// A1, A2, ..., AN denoting the elements of the array. The third line contains an integer 'N' denoting the cents.
//
// Output:
//
// Print number of possible ways to make change for N cents.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 300
// 1 ≤ A[i] ≤ 300
//
// Example:
//
// Input:
//
// 2
// 3
// 1 2 3
// 4
// 4
// 2 5 3 6
// 10
//
// Output:
//
// 4
// 5

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Scanner;

public class P0089_CoinChange {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int M = in.nextInt();
            final int[] A = new int[M];

            for (int i = 0; i < M; i++) {
                A[i] = in.nextInt();
            }

            final int N = in.nextInt();
            printCoinChange(A, N);
        }
    }

    private static void printCoinChange(final int[] coinSet, final int totalValue) {
        long[][] subsetSizeValues = new long[coinSet.length + 1][totalValue + 1];

        for (int subsetSize = 0; subsetSize <= coinSet.length; subsetSize++) {
            for (int value = 0; value <= totalValue; value++) {
                if (subsetSize == 0) {
                    if (value == 0) {
                        subsetSizeValues[subsetSize][value] = 1;
                    }
                } else {
                    for (int previousValue = value; previousValue >= 0; previousValue -= coinSet[subsetSize - 1]) {
                        subsetSizeValues[subsetSize][value] += subsetSizeValues[subsetSize - 1][previousValue];
                    }
                }
            }
        }

        System.out.println(subsetSizeValues[coinSet.length][totalValue]);
    }
}
