// Problem ID: 475. Largest square formed in a matrix.
//
// Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is n and m, n is the number of rows and m is the number of columns.
// The second line of each test case contains array C[n][m] in row major form.
//
// Output:
// Print maximum size square sub-matrix.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ n,m ≤ 50
// 0 ≤ C[n][m] ≤ 1
//
// Example:
//
// Input:
// 3
// 5 6
// 0 1 0 1 0 1 1 0 1 0 1 0 0 1 1 1 1 0 0 0 1 1 1 0 1 1 1 1 1 1
// 2 2
// 1 1 1 1
// 2 2
// 0 0 0 0
//
// Output:
// 3
// 2
// 0

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0475_LargestSquare {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt(), M = in.nextInt();
            final boolean[][] C = new boolean[N][M];

            for (int row = 0; row < N; row++) {
                for (int column = 0; column < M; column++) {
                    C[row][column] = in.nextInt() == 1;
                }
            }

            printLargestSquareSize(C);
        }
    }

    private static void printLargestSquareSize(final boolean[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        final int[][] largestSquareAt = new int[rows][columns];
        int largestSquare = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column]) {
                    if (row == 0 || column == 0) {
                        largestSquareAt[row][column] = 1;
                    } else {
                        largestSquareAt[row][column] = Math.min(largestSquareAt[row - 1][column - 1],
                                Math.min(largestSquareAt[row - 1][column], largestSquareAt[row][column - 1])) + 1;
                    }

                    largestSquare = Math.max(largestSquare, largestSquareAt[row][column]);
                }
            }
        }

        System.out.println(largestSquare);
    }
}
