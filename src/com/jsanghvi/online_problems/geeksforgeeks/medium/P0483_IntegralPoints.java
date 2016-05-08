// Problem ID: 483. Count Integral Points.
//
// Given two points p (x1, y1) and q (x2, y2), calculate the number of integral points lying on the line joining them.
//
// Input: First line of the input is the number of test cases T.  Every test case has one input line. The line contains
// 4 inputs which are x coordinate of p, y coordinate of p, x coordinate of q and y coordinate of 1.
//
// Output: Number of integral points between p and q
//
// Constraints: 0 <= x1, y1, x2, y2 <= 1000
//
// Example:
// Input:
// 2
// 2 2 5 5
// 1 9 8 16
//
// Output:
// 2
// 6

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0483_IntegralPoints {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIntegralPoints(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private static void printIntegralPoints(final int px, final int py, final int qx, final int qy) {
        System.out.println(gcd(Math.abs(px - qx), Math.abs(py - qy)) - 1);
    }

    private static int gcd(final int x, final int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
