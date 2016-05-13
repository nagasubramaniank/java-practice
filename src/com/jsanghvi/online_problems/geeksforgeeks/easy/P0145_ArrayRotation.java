// Problem ID: 145. Rotation.
//
// Given a sorted array which is rotated 'N' times. Find the value of 'N'.
//
// Input:
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N depicting the size of array and next line followed by the value of array.
//
// Output:
// Print the value of 'n'.
//
// Constraints:
// 1 ≤ T ≤ 40
// 1 ≤ N ≤ 100
// 0 ≤ A[i] ≤ 100
//
// Example:
//
// Input
// 2
// 5
// 5 1 2 3 4
// 5
// 1 2 3 4 5
//
// Output
// 1
// 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0145_ArrayRotation {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printRotationPosition(A);
        }
    }

    private static void printRotationPosition(final int[] array) {
        int previousNumber = Integer.MIN_VALUE;

        for (int position = 1; position < array.length; position++) {
            if (array[position] < array[position - 1]) {
                System.out.println(position);
                return;
            }
        }

        System.out.println(0);
    }
}
