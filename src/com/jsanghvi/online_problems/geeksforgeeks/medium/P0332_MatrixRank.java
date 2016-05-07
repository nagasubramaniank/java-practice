// Problem ID: 332. Rank of Matrix.
//
// Write a program to find the rank of a 3x3 Matrix.
//
// Input: The first line contains an integer 'T' denoting the total number of test cases. Each test case consists of 3
// lines and each line consists of 3 integers. First 3 lines denotes a matrix of whose rank is to be determined.
//
// Output: Rank of the matrix is displayed in one line.
//
// Constraints:
// 1 <= T <= 100
// -100 <= N <= 100
//
// Example:
//
// Input:
// 2
// 10 20 10
// -20 -30 10
// 30 50 0
// 2 4 3
// 1 0 9
// 9 6 8
//
// Output:
// 2
// 3

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0332_MatrixRank {
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            double[][] matrix = new double[ROWS][COLUMNS];

            for (int row = 0; row < ROWS; row++) {
                for (int column = 0; column < COLUMNS; column++) {
                    matrix[row][column] = in.nextDouble();
                }
            }

            printMatrixRank(matrix);
        }
    }

    private static void printMatrixRank(final double[][] matrix) {
        final int dimension = Math.min(ROWS, COLUMNS);

        for (int dim = 0; dim < dimension; dim++) {
            final int pivotRow = findPivot(matrix, dim);
            swapRows(matrix, dim, pivotRow);
            for (int row = dim + 1; row < ROWS; row++) {
                double multiple = matrix[row][dim] / matrix[dim][dim];
                matrix[row][dim] = 0.0;
                for (int column = dim + 1; column < COLUMNS; column++) {
                    matrix[row][column] -= multiple * matrix[dim][column];
                }
            }
        }

        System.out.println(getRank(matrix));
    }

    private static int findPivot(final double[][] matrix, final int dim) {
        int pivotRow = dim;
        for (int row = dim + 1; row < ROWS; row++) {
            if (Math.abs(matrix[pivotRow][dim]) < Math.abs(matrix[row][dim])) {
                pivotRow = row;
            }
        }
        return pivotRow;
    }

    private static void swapRows(final double[][] matrix, int row1, int row2) {
        double[] tempRow = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = tempRow;
    }

    private static int getRank(double[][] matrix) {
        final double EPSILON = 1e-6;
        int rank = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (Math.abs(matrix[row][column]) > EPSILON) {
                    rank += 1;
                    break;
                }
            }
        }

        return rank;
    }
}
