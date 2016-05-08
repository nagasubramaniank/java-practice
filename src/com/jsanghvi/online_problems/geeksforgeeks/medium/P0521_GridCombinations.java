// Problem ID: 521. Number of ways.
//
// Given a tile of size 1 x 4, how many ways you can construct a grid of size N x 4.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N.
//
// Output:
// Print number of possible ways.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 80
//
// Example:
//
// Input:
// 3
// 1
// 4
// 5
//
// Output:
// 1
// 2
// 3

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0521_GridCombinations {
    public static void main(final String[] args) {
        final long[] gridCombinations = getGridCombinations(80);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printGridCombinations(in.nextInt(), gridCombinations);
        }
    }

    private static void printGridCombinations(final int gridSize, final long[] gridCombinations) {
        System.out.println(gridCombinations[gridSize]);
    }

    private static long[] getGridCombinations(final int maximumGridSize) {
        final long[] gridCombinations = new long[maximumGridSize + 1];

        gridCombinations[0] = gridCombinations[1] = gridCombinations[2] = gridCombinations[3] = 1;

        for (int gridSize = 4; gridSize <= maximumGridSize; gridSize++) {
            gridCombinations[gridSize] = gridCombinations[gridSize - 1] + gridCombinations[gridSize - 4];
        }

        return gridCombinations;
    }
}
