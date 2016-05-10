// Problem ID: 595. Largest sub-square surrounded by ‘X’.
//
// Given a matrix where every element is either ‘O’ or ‘X’, find the largest sub-square surrounded by ‘X’.
//
// Input:
//
// First line contains number of test cases T. For each test case, first line contains the integer value 'N' denoting
// the order of square matrix. Last line contains NxN elements in a single line in row-major order.
//
// Output:
//
// Print the size of largest sub-square surrounded by ‘X’.
//
// Constraints:
//
// 1 <= T <= 50
// 1 <= N <= 10
//
// Example:
//
// Input:
// 2
// 2
// X X X X
// 4
// X X X O X O X X X X X O X O X X
//
// Output:
// 2
// 3
//
// Explanation:
//
// In first example above, input represents following matrix of size 2 x 2
// X X
// X X
// The largest square sub-matrix surrounded by X is the whole input matrix.
//
// In second example above, input represents following matrix of size 4 x 4//
// X X X O
// X O X X
// X X X O
// X O X X
//
// The square sub-matrix starting at (0,0) and end at (2,2) is the largest sub-matrix surrounded by ‘X’. Therefore, size
// of that matrix would be 3.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0595_LargestSquare {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final boolean[][] matrix = new boolean[N][N];

            for (int row = 0; row < N; row++) {
                for (int column = 0; column < N; column++) {
                    matrix[row][column] = in.next().equals("X");
                }
            }

            printLargestSquare(matrix);
        }
    }

    private static void printLargestSquare(final boolean[][] matrix) {
        final int size = matrix.length;
        final int[][] horizontalLengths = new int[size + 1][size + 1];
        final int[][] verticalLengths = new int[size + 1][size + 1];

        int largestSquareLength = 0;

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (matrix[row][column]) {
                    horizontalLengths[row + 1][column + 1] = horizontalLengths[row + 1][column] + 1;
                    verticalLengths[row + 1][column + 1] = verticalLengths[row][column + 1] + 1;

                    for (int length = Math.min(horizontalLengths[row + 1][column + 1], verticalLengths[row + 1][column + 1]);
                         length > largestSquareLength; length--) {
                        if (horizontalLengths[row - length + 2][column + 1] >= length
                                && verticalLengths[row + 1][column - length + 2] >= length) {
                            largestSquareLength = length;
                        }
                    }
                }
            }
        }

        System.out.println(largestSquareLength);
    }
}
