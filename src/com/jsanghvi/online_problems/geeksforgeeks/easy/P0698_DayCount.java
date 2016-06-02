// Problem ID: Number of days.
//
// Find the number of days required to reach the top of the staircase of Q stairs if one moves R stairs upwards during
// daytime and S stairs downwards during night.
//
// Input:
//
// The input starts with number of test cases, T. Then follows T test cases. Each test case consists of three integers
// R, S and Q separated by space in a single line.
//
// Output:
//
// For each test case, print the number of days required in a new line.
//
// Constraints:
//
// 1 <= T <= 100
// 1 <= S <= R <= Q <= 10^9
//
// Example:
//
// Input:
// 1
// 5 1 6
//
// Output:
// 2

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0698_DayCount {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNumberOfDays(in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private static void printNumberOfDays(final int upCount, final int downCount, final int steps) {
        if (upCount == downCount) {
            System.out.println(1);
        } else {
            System.out.println((int) Math.ceil((double) (steps - upCount) / (upCount - downCount)) + 1);
        }
    }
}
