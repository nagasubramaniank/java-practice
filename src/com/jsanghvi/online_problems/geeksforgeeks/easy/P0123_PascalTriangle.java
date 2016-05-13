// Problem ID: 123. Pascal Triangle.
//
// Given an integer K, return the kth row of pascal triangle. Pascal's triangle is a triangular array of the binomial
// coefficients formed by summing up the elements of previous row.
//
// Example of pascal triangle:
// 1
// 1 1
// 1 2 1
// 1 3 3 1
//
// for K=3, return 3rd row i.e 1 2 1
//
// Input:
//
// The first line contains an integer T,depicting total number of test cases.
// Then following T lines contains an integer N depicting the row of triangle to be printed.
//
// Output:
//
// Print the Nth row of triangle in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 25
//
//
// Example:
//
// Input
// 1
// 4
//
// Output
// 1 3 3 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0123_PascalTriangle {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printPascalTriangleRow(in.nextInt());
        }
    }

    private static void printPascalTriangleRow(final int row) {
        StringBuilder sequence = new StringBuilder();
        sequence.append(1).append(' ');

        for (int position = 1, value = 1; position < row; position++) {
            value = value * (row - position) / position;
            sequence.append(value).append(' ');
        }

        System.out.println(sequence);
    }
}
