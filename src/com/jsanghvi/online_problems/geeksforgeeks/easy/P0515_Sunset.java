// Problem ID: 515. Facing the sun.
//
// An array of buildings is facing the sun. The heights of the building is given in an array. You have to tell which all
// buildings will see the sunset.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the number of buildings.
// The second line of each test case contains N input H[i],height of building.
//
// Output:
// Print the total number of buildings which will see the sunset.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 500
// 1 ≤ H[i] ≤ 1000
//
// Example:
//
// Input:
// 2
// 5
// 7 4 8 2 9
// 4
// 2 3 4 5
//
// Output:
// 3
// 4

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0515_Sunset {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] H = new int[N];

            for (int i = 0; i < N; i++) {
                H[i] = in.nextInt();
            }

            printBuildingCount(H);
        }
    }

    private static void printBuildingCount(final int[] heights) {
        int buildingCount = 0;
        int maximumHeight = 0;
        for (int height : heights) {
            if (maximumHeight < height) {
                maximumHeight = height;
                buildingCount += 1;
            }
        }

        System.out.println(buildingCount);
    }
}
