// Problem ID: 486. Addition of submatrix.
//
// Given a matrix of size n x m. You are given a series of submatrix inside the matrix. Find the sum of all elements inside that submatrix. Submatrix position are given in terms of its: top_left_cell and bottom_right_cell.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is n and m,n is the number of rows and m is the number of columns.
// The second line of each test case contains C[n][m].
// The third line contains four value of x1, y1, x2, y2.
// x1, y1 is the top left cell and x2, y2 is the bottom right cell.
//
// Output:
// Print the sum of all elements inside that submatrix.
//
// Constraints:
// 1 ≤ T ≤ 15
// 1 ≤ n,m ≤ 10
// 1 ≤ C[n][m] ≤ 1000
//
// Example:
//
// Input:
// 2
// 5 6
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
// 3 4 4 5
// 3 3
// 9 8 7 4 2 1 6 5 3
// 1 2 3 3
//
// Output:
// 78
// 26

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0486_SubmatrixAddition {
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

            printSubmatrixAddition(A, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private static void printSubmatrixAddition(final int[][] matrix, final int x1, final int y1, final int x2,
                                               final int y2) {

        int sum = 0;
        for (int row = x1 - 1; row < x2; row++) {
            for (int column = y1 - 1; column < y2; column++) {
                sum += matrix[row][column];
            }
        }

        System.out.println(sum);
    }
}
