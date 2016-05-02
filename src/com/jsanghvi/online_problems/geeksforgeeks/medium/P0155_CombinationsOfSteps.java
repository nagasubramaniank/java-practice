// Problem ID: 155. Count ways to reach the n’th stair.
//
// There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2
// stairs at a time. Count the number of ways, the person can reach the top (order does matter).
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, an integer N will
// be given.
//
// Output:
// Print number of possible ways to reach Nth stair. Answer your output % 10^9+7.
//
// Constraints:
// 1 <= T <= 1000
// 1 <= N <= 100
//
// Example:
//
// Input:
// 3
// 4
// 10
// 24
//
// Output:
// 5
// 89
// 75025

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0155_CombinationsOfSteps {
    public static void main(final String args[]) {
        final int[] stepsForStairs = constructStepsForStairs();
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            System.out.println(stepsForStairs[in.nextInt()]);
        }
    }

    private static int[] constructStepsForStairs() {
        final int[] stepsForStairs = new int[101];
        stepsForStairs[0] = stepsForStairs[1] = 1;

        for (int i = 2; i <= 100; i++) {
            stepsForStairs[i] = (stepsForStairs[i - 1] + stepsForStairs[i - 2]) % 1000000007;
        }

        return stepsForStairs;
    }
}
