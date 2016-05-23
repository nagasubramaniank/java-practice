// Problem ID: 591. Adjacent are not allowed.
//
// You have a rectangular grid of dimension 2 x N. you need to find out the maximum sum such that no two chosen numbers
// are adjacent, vertically, diagonally or horizontally.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N, number of columns in a grid.
// Next two lines describes the 2*N grid.
//
// Output:
// Print the output for each test case in a separate line.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= arr[i] <= 70
//
// Example:
//
// Input:
// 1
// 3
// 1 4 5
// 2 0 0
//
// Output:
// 7

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0591_SumDistantElements {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A1 = new int[N], A2 = new int[N];

            for (int i = 0; i < N; i++) {
                A1[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                A2[i] = in.nextInt();
            }

            printMaximumSum(A1, A2);
        }
    }

    private static void printMaximumSum(final int[] sequence1, final int[] sequence2) {
        int[] lastMaximums = new int[4];

        for (int i = 0; i < sequence1.length; i++) {
            lastMaximums[0] = Math.max(lastMaximums[2], lastMaximums[3]) + Math.max(sequence1[i], sequence2[i]);
            lastMaximums[3] = lastMaximums[2];
            lastMaximums[2] = lastMaximums[1];
            lastMaximums[1] = lastMaximums[0];
        }

        System.out.println(Math.max(lastMaximums[1], lastMaximums[2]));
    }
}
