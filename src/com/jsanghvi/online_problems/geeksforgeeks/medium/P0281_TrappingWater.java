// Problem ID: 281. Trapping Rain Water.
//
// Given n non-negative integers in array representing an elevation map where the width of each bar is 1, compute how
// much water it is able to trap after raining.
//
// For example:
// Input:
// 3
// 2 0 2
// Output:
// 2
// We can trap 2 units of water in the middle gap.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. Each test case contains an integer N followed by N numbers to be stored in array.
//
// Output:
// Print trap units of water in the middle gap.
//
// Constraints:
// 1 <= T <= 100
// 3 <= N <= 100
// 0 <= Arr[i] < 10
//
// Example:
// Input:
// 2
// 4
// 7 4 0 9
// 3
// 6 9 9
//
// Output:
// 10
// 0

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0281_TrappingWater {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printTrappedWaterVolume(A);
        }
    }

    private static void printTrappedWaterVolume(final int[] barHeights) {
        final int[] maximumOnLeft = new int[barHeights.length];
        maximumOnLeft[0] = barHeights[0];
        for (int i = 1; i < barHeights.length; i++) {
            maximumOnLeft[i] = Math.max(maximumOnLeft[i - 1], barHeights[i]);
        }

        final int[] maximumOnRight = new int[barHeights.length];
        maximumOnRight[barHeights.length - 1] = barHeights[barHeights.length - 1];
        for (int i = barHeights.length - 2; i > -1; i--) {
            maximumOnRight[i] = Math.max(maximumOnRight[i + 1], barHeights[i]);
        }

        int waterVolume = 0;
        for (int i = 0; i < barHeights.length; i++) {
            waterVolume += Math.min(maximumOnLeft[i], maximumOnRight[i]) - barHeights[i];
        }

        System.out.println(waterVolume);
    }
}
