// Problem ID: 91. Minimum Points to Reach Destination.
//
// Given a grid with each cell consisting of positive, negative or no points i.e., zero points. We can move across a
// cell only if we have positive points (> 0). Whenever we pass through a cell, points in that cell are added to our
// overall points. We need to find minimum initial points to reach cell (m-1, n-1) from (0, 0) by following these
// certain set of rules :
//
// 1. From a cell (i, j) we can move to (i+1, j) or (i, j+1).
// 2. We cannot move from (i, j) if your overall points at (i, j) is <= 0.
// 3. We have to reach at (m-1, n-1) with minimum positive points i.e., > 0.
//
// Example:
//
// Input: points[m][n] = { {-2, -3,   3}, {-5, -10,  1}, {10,  30, -5} };
// Output: 7
// Explanation:
// 7 is the minimum value to reach destination with positive throughout the path. Below is the path.
//
// (0,0) -> (0,1) -> (0,2) -> (1, 2) -> (2, 2)
//
// We start from (0, 0) with 7, we reach(0, 1) with 5, (0, 2) with 2, (1, 2) with 5, (2, 2) with and finally we have
// 1 point (we needed greater than 0 points at the end).
//
// Input:
//
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains two integer 'R' and 'C' denoting the number of rows and column of array. The second line contains the value
// of the array i.e the grid, in a single line separated by spaces in row major order.
//
// Output:
//
// Print the minimum initial points to reach the bottom right most cell in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ R,C ≤ 10
// -30 ≤ A[R][C] ≤ 30
//
// Example:
//
// Input:
// 1
// 3 3
// -2 -3 3 -5 -10 1 10 30 -5
//
// Output:
// 7

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Scanner;

public class P0091_MinimumPoints {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int R = in.nextInt();
            final int C = in.nextInt();
            final int[][] A = new int[R][C];

            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    A[row][col] = in.nextInt();
                }
            }

            printMinimumPoints(A);
        }
    }

    private static void printMinimumPoints(final int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        final int[][] minimumPoints = new int[rows][cols];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                int minimum = (row == rows - 1 && col == cols - 1) ? 1 : Integer.MAX_VALUE;

                if (row < rows - 1) {
                    minimum = Math.min(minimum, minimumPoints[row + 1][col]);
                }

                if (col < cols - 1) {
                    minimum = Math.min(minimum, minimumPoints[row][col + 1]);
                }

                minimumPoints[row][col] = Math.max(minimum - grid[row][col], 1);
            }
        }


        System.out.println(minimumPoints[0][0]);
    }
}
