// Problem ID: 264. Forming Rectangle.
//
// Given a positive integer N denoting the length of a stick, return the number of ways to split a stick into four parts
// so that it's possible to form a rectangle using these parts, but is impossible to form a square.
//
// Input:
// The first line contains T denoting the number of test cases. Then follows description of test cases. Each case
// contains a single positive integer N denoting the length of a stick.
//
// Output:
// For each test case, output a single line containing the number of ways to form rectangle by splitting given stick.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10^9
//
// Example:
//
// Input:
// 2
// 10
// 20
//
// Output:
// 2
// 4
//
// Explanation:
// In the first example, the 2 ways to split the stick are {1,1,4,4}, {2,2,3,3}.
// In the second example, the 4 ways to split the stick are {1,1,9,9}, {2,2,8,8}, {3,3,7,7} and {4,4,6,6}.
// Note that {5,5,5,5} forms square so it is not considered.


package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0264_FormingRectangle {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printRectangleCount(in.nextInt());
        }
    }

    private static void printRectangleCount(final int stickLength) {
        System.out.println(stickLength % 2 == 0 ? (stickLength - 1) / 4 : 0);
    }
}
