// Problem ID: 589. Reach the nth point.
//
// There are N points on the road ,you can step ahead by 1 or 2 . Find the number of ways you can reach at point N. For
// example:  for n=4 we have 5 possible ways [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2].
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. Next line of each input contains a
// single integer N.
//
// Output:
// Print the output of each test case in a new line.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 90
//
// Example:
//
// Input:
// 2
// 4
// 5
//
// Output:
// 5
// 8

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0589_StepCount {
    public static void main(final String[] args) {
        final long[] stepCounts = getStepCounts(90);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printStepCount(in.nextInt(), stepCounts);
        }
    }

    private static void printStepCount(final int points, final long[] stepCounts) {
        System.out.println(stepCounts[points]);
    }

    private static long[] getStepCounts(final int limit) {
        final long[] stepCounts = new long[limit + 1];
        stepCounts[0] = stepCounts[1] = 1;

        for (int i = 2; i <= limit; i++) {
            stepCounts[i] = stepCounts[i - 1] + stepCounts[i - 2];
        }

        return stepCounts;
    }
}
