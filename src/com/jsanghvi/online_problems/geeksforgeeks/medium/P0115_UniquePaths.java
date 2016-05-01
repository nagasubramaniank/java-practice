// Problem ID: 115. Number of Unique Paths.
//
// Given a M x N matrix with initial position at top-left corner, find the number of possible unique paths to reach the
// bottom right corner of the grid from the initial position.
//
// NOTE: Possible moves can be either down or right at any point in time, i.e., we can move to matrix[i+1][j] or
// matrix[i][j+1] from matrix[i][j].
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an two
// integers A and B depicting the size of the grid.
//
// Output:
//
// Print the number of unique paths to reach bottom-right corner from the top-left corner.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ M ≤ 15
// 1 ≤ N ≤ 15
//
// Example:
//
// Input
// 2
// 2 2
// 3 4
//
// Output
// 2
// 10

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0115_UniquePaths {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printUniquePaths(in.nextInt(), in.nextInt());
        }
    }

    private static void printUniquePaths(final int rows, final int columns) {
        System.out.println(nChooseK(rows + columns - 2, rows - 1));
    }

    private static int nChooseK(final int N, int K) {
        int answer = 1;
        K = Math.min(N - K, K);

        for (int k = 0; k < K; k++) {
            answer = answer * (N - k) / (k + 1); // Don't use *= operator as we need to multiply first before divide.
        }

        return answer;
    }
}
