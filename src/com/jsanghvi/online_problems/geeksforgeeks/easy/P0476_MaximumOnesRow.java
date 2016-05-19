// Problem ID: 476. Row with max 1s.
//
// Given a boolean 2D array. Find the row with the maximum number of 1s.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is n and m, n is the number of rows and m is the number of columns.
// The second line of each test case contains C[n][m].
//
// Output:
//
// Print the row with the maximum number of 1s.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ n,m ≤ 50
// 0 ≤ C[] ≤ 1
//
// Example:
//
// Input:
// 1
// 4 4
// 0 1 1 1 0 0 1 1 1 1 1 1 0 0 0 0
//
// Output:
// 2

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0476_MaximumOnesRow {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int M = in.nextInt();
            final int[][] A = new int[N][M];

            for (int row = 0; row < N; row++) {
                for (int column = 0; column < M; column++) {
                    A[row][column] = in.nextInt();
                }
            }

            printMaximumOnesRow(A);
        }
    }

    private static void printMaximumOnesRow(final int[][] matrix) {
        final int rows = matrix.length;

        int maximumOnes = 0;
        int maximumOnesRow = 0;

        for (int row = 0; row < rows; row++) {
            int ones = 0;
            for (int cell : matrix[row]) {
                ones += (cell != 0 ? 1 : 0);
            }

            if (maximumOnes < ones) {
                maximumOnes = ones;
                maximumOnesRow = row;
            }
        }

        System.out.println(maximumOnesRow);
    }
}
