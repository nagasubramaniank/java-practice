// Problem ID: 148. Rectangles in N*N Board.
//
// Find total number of Rectangles (excluding squares) in a N*N chessboard.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases.
// Then following T lines contains an integer N that is the side of the chessboard.
//
// Output:
//
// Each separate line showing the maximum number of rectangles possible.
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
// 0
// 4
//
// Explanation :
//
// For n=1 there is only one square possible and no rectangles so answer will be 0.
// For n=2 there will be 2 rectangles of dimension 1*2 and 2 rectangles of dimension 2*1. So answer if 4.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0148_TotalRectangles {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printTotalRectangles(in.nextInt());
        }
    }

    private static void printTotalRectangles(final long size) {
        // Take number of possible x-coordinates of rectangle * number of possible y-coordinates of rectangle
        long rectangles = (size * (size + 1) / 2) * (size * (size + 1) / 2);

        // Subtract from it total number of possible squares
        rectangles -= (size) * (size + 1) * (2 * size + 1) / 6;

        System.out.println(rectangles);
    }
}
