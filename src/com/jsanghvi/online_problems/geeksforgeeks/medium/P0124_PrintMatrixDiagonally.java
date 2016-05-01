// Problem ID: 124. Print Diagonally.
//
// Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
//
// For Example:
//
// If the matrix is
//
// 1 2 3
// 4 5 6
// 7 8 9
//
// The output should Return the following :
//
// [
// [1],
// [2, 4],
// [3, 5, 7],
// [6, 8],
// [9]
// ]
// i.e print the elements of array diagonally.
//
// Note: The input array given is in single line and you have to output the answer in one line only.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases.
// Then following T lines contains an integer N depicting the size of square matrix and next line followed by the value
// of array.
//
// Output:
//
// Print the elements of matrix diagonally in separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 20
// 0 ≤ A[i][j] ≤ 9
//
// Example:
//
// Input:
// 2
// 2
// 1 2 3 4
// 3
// 1 2 3 4 5 6 7 8 9
//
// Output:
// 1 2 3 4
// 1 2 4 3 5 7 6 8 9

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0124_PrintMatrixDiagonally {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[][] A = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = in.nextInt();
                }
            }

            printMatrixDiagonally(A);
        }
    }

    private static void printMatrixDiagonally(final int[][] matrix) {
        final int size = matrix.length;
        final int diagonals = 2 * size - 1;

        for (int diagonal = 0; diagonal < diagonals; diagonal++) {
            final int startRow = (diagonal < size ? 0 : diagonal - size + 1);
            final int startColumn = (diagonal < size ? diagonal : size - 1);

            for (int row = startRow, column = startColumn; row < size && column >= 0; row++, column--) {
                System.out.print(matrix[row][column] + " ");
            }
        }

        System.out.println();
    }
}
