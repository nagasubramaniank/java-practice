// Problem ID: 441. Black and White.
//
// How many ways are there to place a black and a white knight on an N * M chessboard such that they do not attack each
// other? The knights have to be placed on different squares. A knight can move two squares horizontally and one square
// vertically, or two squares vertically and one square horizontally. The knights attack each other if one can reach the
// other in one move.
//
// Input:
// The first line contains the number of test cases T. Each of the next T lines contains two integers N and M.
//
// Output:
// Output T lines, one for each test case, each containing the required answer for the corresponding test case.
//
// Constraints:
// 1 <= T <= 10000
// 1 <= N,M <= 100000
//
// Example:
//
// Input:
// 3
// 2 2
// 2 3
// 4 5
//
// Output:
// 12
// 26
// 312

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0441_KnightPlacements {
    private static int[][] lookup = new int[][]{
            {0, 2, 6, 12},
            {2, 12, 26, 48},
            {6, 26, 56, 104},
            {12, 48, 104, 192}
    };

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printTotalPlacements(in.nextInt(), in.nextInt());
        }
    }

    private static void printTotalPlacements(final int rows, final int columns) {
        if (rows < 4 && columns < 4) {
            System.out.println(lookup[rows - 1][columns - 1]);
            return;
        }

        final int dim1 = Math.min(rows, columns);
        final int dim2 = Math.max(rows, columns);

        int result = 0;
        switch (dim1) {
            case 1:
                result = dim2 * (dim2 - 1);
                break;
            case 2:
                result = 8 * (2 * dim2 - 2) + (2 * dim2 - 8) * (2 * dim2 - 3);
                break;
            case 3:
                result = 8 * (3 * dim2 - 3) + 4 * (3 * dim2 - 4) + (3 * dim2 - 12) * (3 * dim2 - 5);
                break;
            default:
                result = 4 * (dim1 * dim2 - 3) + 8 * (dim1 * dim2 - 4)
                        + (2 * (dim1 - 4) + 2 * (dim2 - 4) + 4) * (dim1 * dim2 - 5)
                        + (2 * (dim1 - 4) + 2 * (dim2 - 4)) * (dim1 * dim2 - 7)
                        + (dim1 - 4) * (dim2 - 4) * (dim1 * dim2 - 9);
                break;
        }

        System.out.println(result);
    }
}
