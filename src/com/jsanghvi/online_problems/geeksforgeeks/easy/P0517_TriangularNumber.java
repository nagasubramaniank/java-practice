// Problem ID: 517. Triangular Number.
//
// Check whether the number is Triangular or not. A number is termed as triangular number if we can represent it in the
// form of triangular grid of points such that the points form an equilateral triangle and each row contains as many
// points as the row number, i.e., the first row has one point, second row has two points, third row has three points
// and so on. The starting triangular numbers are 1, 3 (1+2), 6 (1+2+3), 10 (1+2+3+4).
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The first line of each test case
// is N, N is the number to be checked if it is triangular or not.
//
// Output:
// If the number is Triangular then display 1 otherwise 0.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 1000000
//
// Example:
//
// Input:
// 5
// 3
// 4
// 6
// 55
// 345
//
// Output:
// 1
// 0
// 1
// 1
// 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0517_TriangularNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsTriangularNumber(in.nextInt());
        }
    }

    private static void printIsTriangularNumber(final int number) {
        int n = (int) Math.sqrt(2 * number);
        System.out.println(n * (n + 1) / 2 == number ? 1 : 0);
    }
}
