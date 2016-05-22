// Problem ID: 522. Greater on right side.
//
// Given an array of integers, replace every element with the next greatest element (greatest element on the right side)
// in the array. Since there is no element next to the last element, replace it with -1.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input A[i].
//
// Output:
// Print the modified array.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 100
// 1 ≤ A[i] ≤ 1000
//
// Example:
//
// Input:
// 2
// 6
// 16 17 4 3 5 2
// 4
// 2 3 1 9
//
// Output:
// 17 5 5 5 2 -1
// 9 9 9 -1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0522_GreatestOnRight {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printRightGreatestElements(A);
        }
    }

    private static void printRightGreatestElements(final int[] array) {
        final int[] rightGreatestElements = new int[array.length];
        rightGreatestElements[array.length - 1] = -1;

        for (int i = array.length - 2; i >= 0; i--) {
            rightGreatestElements[i] = Math.max(rightGreatestElements[i + 1], array[i + 1]);
        }

        for (final int rightGreatestElement : rightGreatestElements) {
            System.out.print(rightGreatestElement + " ");
        }
        System.out.println();
    }
}
