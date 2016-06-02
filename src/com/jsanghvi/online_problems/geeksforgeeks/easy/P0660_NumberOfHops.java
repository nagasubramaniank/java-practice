// Problem ID: 660. Count number of hops.
//
// Frog steps either 1, 2 or 3 steps to go to top. In how many ways it reaches the top?
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N. Where is the number of steps it has to hop.
//
// Output:
//
// Print the number of ways.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 50
//
// Example:
//
// Input:
// 2
// 1
// 5
//
// Output:
// 1
// 13

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0660_NumberOfHops {
    public static void main(final String[] args) {
        final long[] hops = getHopCount(50);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNumberOfHops(in.nextInt(), hops);
        }
    }

    private static void printNumberOfHops(final int steps, final long[] hops) {
        System.out.println(hops[steps]);
    }

    private static long[] getHopCount(final int maximumSteps) {
        final long[] hops = new long[maximumSteps + 1];

        hops[0] = 1;
        for (int step = 1; step <= maximumSteps; step++) {
            hops[step] = (step >= 1 ? hops[step - 1] : 0) + (step >= 2 ? hops[step - 2] : 0)
                    + (step >= 3 ? hops[step - 3] : 0);
        }

        return hops;
    }
}
