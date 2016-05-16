// Problem ID: 383. Number of paths in a matrix with k coins.
//
// Given a matrix where every cell has some number of coins. Count number of ways to reach bottom right from top left
// with exactly k coins. We can move to (i+1, j) and (i, j+1) from a cell (i, j).
//
// Input:
// First line contains number of test cases T. For each test case, first line contains the integer value 'k' denoting
// coins, second line contains an integer 'N' denoting the order of square matrix. Last line contains NXN elements in a
// single line in row-major order.
//
// Output:
// Number of paths are displayed as output to the user. '0' is displayed when no path is found.
//
// Constraints:
// 1 <= T <= 100
// 1 <= k <= 20
// 1 <= N <= 10
// 1 <= arr[i] <= 100
//
// Example:
//
// Input:
// 2
// 16
// 3
// 1 2 3 4 6 5 9 8 7
// 12
// 3
// 1 2 3 4 6 5 3 2 1
//
// Output:
// 0
// 2

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0383_MatrixPaths {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int K = in.nextInt();
            final int N = in.nextInt();
            final int[][] A = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int column = 0; column < N; column++) {
                    A[row][column] = in.nextInt();
                }
            }

            printPathCountWithSum(A, K);
        }
    }

    private static void printPathCountWithSum(final int[][] matrix, final int requiredSum) {
        final int length = matrix.length;
        final int[][][] pathCount = new int[length][length][requiredSum + 1];

        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                for (int sum = 1; sum <= requiredSum; sum++) {
                    if (matrix[row][column] <= sum) {
                        if (row == 0 && column == 0) {
                            pathCount[row][column][sum] = (sum == matrix[row][column] ? 1 : 0);
                        } else {
                            pathCount[row][column][sum]
                                    = (row > 0 ? pathCount[row - 1][column][sum - matrix[row][column]] : 0)
                                    + (column > 0 ? pathCount[row][column - 1][sum - matrix[row][column]] : 0);
                        }
                    }
                }
            }
        }
        System.out.println(pathCount[length - 1][length - 1][requiredSum]);
    }
}
