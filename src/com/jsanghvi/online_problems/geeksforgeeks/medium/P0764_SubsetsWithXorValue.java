// Problem ID: 764. Subsets with xor value.
//
// Given an array arr[] of N integers and a integer K, find the number of subsets of arr[] having XOR of elements as K.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test
// case consists of two lines. The first line of each test case contains two space separated integers N and K as
// described in the problem statement. Second line of each test case contains N space separated integers denoting the
// array arr[].
//
// Output:
// Corresponding to each test case, print a single line containing an integer denoting the total number of subsets of
// arr[] having XOR of their elements as K.
//
// Constraints:
// 1 <= T <= 10
// 1 <= N <= 20
// 1 <= K <= 100
// 0 <= arr[i] <= 100
//
// Example:
// Input:
// 1
// 4 6
// 6 9 4 2
//
// Output:
// 2
//
// Explanation:
// The subsets are {4,2} and {6}

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0764_SubsetsWithXorValue {
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

            printSubsetCount(A, K);
        }
    }

    private static void printSubsetCount(final int[] numbers, final int requiredXorValue) {
        final int maxXorValue = 127;
        final int[][] subsetCount = new int[numbers.length + 1][maxXorValue + 1];

        for (int subsetSize = 0; subsetSize <= numbers.length; subsetSize++) {
            for (int xorValue = 0; xorValue <= maxXorValue; xorValue++) {
                if (subsetSize == 0) {
                    subsetCount[subsetSize][xorValue] = xorValue == 0 ? 1 : 0;
                } else {
                    subsetCount[subsetSize][xorValue] = subsetCount[subsetSize - 1][xorValue]
                            + subsetCount[subsetSize - 1][xorValue ^ numbers[subsetSize - 1]];
                }
            }
        }

        System.out.println(subsetCount[numbers.length][requiredXorValue]);
    }
}
