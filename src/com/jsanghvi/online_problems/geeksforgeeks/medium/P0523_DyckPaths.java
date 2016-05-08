// Problem ID: 523. Dyck Path.
//
// Consider a n x n grid with indexes of top left corner as (0, 0). Dyck path is a staircase walk from bottom left,
// i.e., (n-1, 0) to top right, i.e., (0, n-1) that lies above the diagonal cells (or cells on line from bottom left to
// top right). The task is to count the number of Dyck Paths from (n-1, 0) to (0, n-1).
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// Each test case is in a separate single line containing an Integer n, representing a grid of n x n.
//
// Output:
// Print the number of dyck paths corresponding to each test in a separate line.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ n ≤ 30
//
// Example:
//
// Input
// 2
// 4
// 3
//
// Output
// 14
// 5

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0523_DyckPaths {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printDyckPathCount(in.nextInt());
        }
    }

    private static void printDyckPathCount(final int size) {
        System.out.println(nChooseR(2 * size, size) / (size + 1));
    }

    private static long nChooseR(final int N, int R) {
        long result = 1;
        for (int r = 0; r < R; r++) {
            result = result * (N - r) / (r + 1);
        }
        return result;
    }
}
