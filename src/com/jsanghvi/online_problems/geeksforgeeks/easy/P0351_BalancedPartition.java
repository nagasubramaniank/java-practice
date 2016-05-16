// Problem ID: 351. Subset Sum Problem.
//
// Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both
// subsets is same or not.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. Each test case constitutes of two
// lines. First line contains 'N', representing the number of elements in the set and the second line contains the
// elements of the set.
//
// Output:
// Print YES if the given set can be partitioned into two subsets such that the sum of elements in both subsets is equal,
// else print NO.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= arr[i] <= 1000
//
// Example:
//
// Input:
// 2
// 4
// 1 5 11 5
// 3
// 1 3 5
//
// Output:
//
// YES
// NO

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0351_BalancedPartition {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();

            final int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printBalancePartition(A);
        }
    }

    private static void printBalancePartition(final int[] set) {
        int fullSum = 0;
        for (int element : set) {
            fullSum += element;
        }

        if (fullSum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        final int halfSum = fullSum / 2;
        final boolean[][] canSubsetSumUp = new boolean[set.length + 1][halfSum + 1];

        for (int subsetSize = 0; subsetSize <= set.length; subsetSize++) {
            for (int sum = 0; sum <= halfSum; sum++) {
                if (subsetSize == 0) {
                    canSubsetSumUp[subsetSize][sum] = (sum == 0);
                } else {
                    if (canSubsetSumUp[subsetSize - 1][sum] || (sum >= set[subsetSize - 1]
                            && canSubsetSumUp[subsetSize - 1][sum - set[subsetSize - 1]])) {
                        canSubsetSumUp[subsetSize][sum] = true;
                    }
                }
            }
        }

        System.out.println(canSubsetSumUp[set.length][halfSum] ? "YES" : "NO");
    }
}
