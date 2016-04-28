// Problem ID: 160. Minimum sum partition.
//
// Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums
// is minimum.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of array. The second line contains N space-separated integers
// A1, A2, ..., AN denoting the elements of the array.
//
// Output:
// In each separate line print minimum absolute difference.
//
// Constraints:
// 1 <= T <= 30
// 1 <= N <= 50
// 1 <= A[i] <= 50
//
// Example:
// Input:
// 2
// 4
// 1 6 5 11
// 4
// 36 7 46 40
//
// Output:
// 1
// 23
//
// Explanation:
// Subset1 = {1, 5, 6}, sum of Subset1 = 12
// Subset2 = {11}, sum of Subset2 = 11

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Scanner;

public class P0160_BalancedPartition {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMinimumDifference(A);
        }
    }

    private static void printMinimumDifference(final int[] set) {
        int allSum = 0;
        for (int number : set) {
            allSum += number;
        }

        int halfSum = allSum / 2;
        boolean[][] canSubsetSumUp = new boolean[set.length + 1][halfSum + 1];

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

        for (int sum = halfSum; sum >= 0; sum--) {
            if (canSubsetSumUp[set.length][sum]) {
                System.out.println(allSum - sum - sum);
                return;
            }
        }
    }
}
