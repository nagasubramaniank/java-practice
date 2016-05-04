// Problem ID: 271. Path in Matrix.
//
// Given a N X N matrix Matrix[N][N] of positive integers. There are only three possible moves from a cell Matrix[r][c].
//
// 1. Matrix[r+1][c]
// 2. Matrix[r+1][c-1]
// 3. Matrix[r+1][c+1]
//
// Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
//
// Input:
//
// The first line of the input contains an integer T denoting the number of test cases. The description of T test cases
// follows. The first line of each test case contains a single integer N denoting the size of matrix. Each of the next N
// lines contain N integers denoting the values in the rows of the matrix.
//
// Output:
//
// Output the largest sum of any paths starting from any cell of row 0 to any cell of row N-1.
//
// Constraints:
//
// 1 <= T <= 20
// 2 <= N <= 20
// 1 <= Matrix[i][j] <= 1000 (for all 1 <= i <= N && 1 <= j <= N)
//
// Example:
//
// Input:
// 1
// 3
// 1 2 3
// 4 5 6
// 7 8 9
//
// Output:
// 18
//
// Explanation: In the sample test case, the path leading to maximum possible sum is 3 -> 6 -> 9.  (3 + 6 + 9 = 18)

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0271_MatrixPath {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int column = 0; column < N; column++) {
                    matrix[row][column] = in.nextInt();
                }
            }

            printMaximumPath(matrix);
        }
    }

    private static void printMaximumPath(int[][] matrix) {
        final int size = matrix.length;
        final int[][] pathLengths = new int[size + 1][size + 2];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                pathLengths[row + 1][column + 1] = matrix[row][column] + Math.max(pathLengths[row][column],
                        Math.max(pathLengths[row][column + 1], pathLengths[row][column + 2]));
            }
        }

        int maximumPathLength = 0;
        for (int column = 0; column < size; column++) {
            maximumPathLength = Math.max(maximumPathLength, pathLengths[size][column + 1]);
        }

        System.out.println(maximumPathLength);
    }
}
