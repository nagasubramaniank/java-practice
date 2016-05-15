// Problem ID: 336. Spirally traversing a matrix.
//
// Traverse a 4x4 matrix of integers in spiral form.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. First four lines of the test case
// will contain four elements each.
//
// Output:
// Spiral array will be displayed in a single line.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
//
// Example:
//
// Input:
// 1
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12
// 13 14 15 16
//
// Output:
// 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0336_SpiralTraversal {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int[][] matrix = new int[4][4];

            for (int row = 0; row < 4; row++) {
                for (int column = 0; column < 4; column++) {
                    matrix[row][column] = in.nextInt();
                }
            }

            printSpiralTraversal(matrix);
        }
    }

    private static void printSpiralTraversal(int[][] matrix) {
        System.out.println(matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2] + " " + matrix[0][3] + " "
                + matrix[1][3] + " " + matrix[2][3] + " " + matrix[3][3] + " " + matrix[3][2] + " " + matrix[3][1] + " "
                + matrix[3][0] + " " + matrix[2][0] + " " + matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2] + " "
                + matrix[2][2] + " " + matrix[2][1]);
    }
}
