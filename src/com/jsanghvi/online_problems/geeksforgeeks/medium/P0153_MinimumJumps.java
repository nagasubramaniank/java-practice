// Problem ID: 153. Minimum number of jumps.
//
// Given an array of integers where each element represents the max number of steps that can be made forward from that
// element, write a function to return the minimum number of jumps to reach the end of the array (starting from the
// first element). If an element is 0, then cannot move through that element.
//
// Input:
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains a number
// n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.
//
// Output:
// Each separate line showing the minimum number of jumps. If answer is not possible print -1.
//
// Constraints:
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 100
// 0 ≤ a[N] ≤ 100
//
// Example:
//
// Input:
// 1
// 11
// 1 3 5 8 9 2 6 7 6 8 9
//
// Output:
// 3

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0153_MinimumJumps {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMinimumJumps(A);
        }
    }

    // Thanks to https://youtu.be/vBdo7wtwlXs for the O(n) algorithm.
    private static void printMinimumJumps(final int[] steps) {
        int minimumJumps = 0;
        int currentLadderEnd = 0, nextLadderEnd = 0;

        for (int level = 0; level < steps.length; level++) {

            if (level == steps.length - 1) {
                System.out.println(minimumJumps);
                return;
            }

            nextLadderEnd = Math.max(nextLadderEnd, level + steps[level]);

            // If we reached the end of current ladder, switch to next longest ladder.
            if (currentLadderEnd == level) {

                // Check if no more ladders are remaining.
                if (nextLadderEnd <= level) {
                    System.out.println(-1);
                    return;
                }

                minimumJumps += 1;
                currentLadderEnd = nextLadderEnd;
            }
        }
    }
}
