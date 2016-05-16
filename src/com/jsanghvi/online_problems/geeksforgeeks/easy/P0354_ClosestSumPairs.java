// Problem ID: 354. Two numbers with sum closest to zero.
//
// Given an integer array, you need to find the two elements such that their sum is closest to zero.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,the size of array.
// Each test case consist of a N integers which are the array elements.
//
// Output:
// Print the two numbers in ascending order such that their sum is closest to zero.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 1000
// -100007 ≤ a[i] ≤ 100007
//
// Example:
// Input
// 3
// 3
// -8 -66 -60
// 6
// -21 -67 -37 -18 4 -65
// 2
// -24 -73
//
// Output
// -60 -8
// -18 4
// -73 -24

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0354_ClosestSumPairs {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();

            final int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printClosestSumPairs(A);
        }
    }

    private static void printClosestSumPairs(final int[] array) {
        Arrays.sort(array);

        int minimumDifference = Integer.MAX_VALUE;
        int left = -1, right = -1;
        for (int currentLeft = 0, currentRight = array.length - 1; currentLeft < currentRight; ) {
            final int difference = array[currentLeft] + array[currentRight];
            if (minimumDifference > Math.abs(difference)) {
                minimumDifference = Math.abs(difference);
                left = currentLeft;
                right = currentRight;
            }

            if (difference <= 0) {
                currentLeft += 1;
            } else if (difference > 0) {
                currentRight -= 1;
            } else {
                break;
            }
        }

        System.out.println(array[left] + " " + array[right]);
    }
}
