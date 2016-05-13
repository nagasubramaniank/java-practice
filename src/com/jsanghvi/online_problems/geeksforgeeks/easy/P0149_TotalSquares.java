// Problem ID: 149. Squares in N*N Board.
//
// Find total number of Squares in a N*N chessboard.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases.
// Then following T lines contains an integer N that is the side of the chessboard.
//
// Output:
//
// Each separate line showing the maximum number of squares possible.
//
// Constraints:
//
// 1 ≤ T ≤ 1000
// 1 ≤ N ≤ 10000
//
// Example:
//
// Input :
// 2
// 1
// 2
//
// Output :
// 1
// 5

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0149_TotalSquares {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printTotalSquares(in.nextInt());
        }
    }

    private static void printTotalSquares(final long size) {
        System.out.println((size) * (size + 1) * (2 * size + 1) / 6);
    }
}
