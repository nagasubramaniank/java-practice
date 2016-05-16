// Problem ID: 393. Amount of Water.
//
// An array containing heights of building was given. Its a rainy season. Calculate the amount of water collected
// between all the buildings.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N, N is the number of buildings.
// The second line of each test case contains N input H[i], height of buildings.
//
// Output:
// Print the amount of water collected between all the buildings.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 1000
// 1 ≤ H[i] ≤ 1000
//
// Example:
//
// Input
// 1
// 6
// 1 5 3 7 4 2
//
// Output
// 2

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0393_WaterCollection {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] H = new int[N];

            for (int i = 0; i < N; i++) {
                H[i] = in.nextInt();
            }

            printWaterVolume(H);
        }
    }

    private static void printWaterVolume(final int[] heights) {
        final int[] maxOnLeft = new int[heights.length];
        final int[] maxOnRight = new int[heights.length];

        maxOnLeft[0] = heights[0];
        maxOnRight[heights.length - 1] = heights[heights.length - 1];

        for (int left = 1; left < heights.length; left++) {
            final int right = heights.length - left - 1;
            maxOnLeft[left] = Math.max(maxOnLeft[left - 1], heights[left]);
            maxOnRight[right] = Math.max(maxOnRight[right + 1], heights[right]);
        }

        int waterVolume = 0;
        for (int i = 0; i < heights.length; i++) {
            waterVolume += Math.max(Math.min(maxOnLeft[i], maxOnRight[i]) - heights[i], 0);
        }

        System.out.println(waterVolume);
    }
}
