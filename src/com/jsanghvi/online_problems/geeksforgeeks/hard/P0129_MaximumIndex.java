// Problem ID: 129. Maximum Index.
//
// Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
//
// Example :
//
// A: [3 5 4 2]
// Output: 2 for the pair (3, 4)
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N depicting the size of array and next line followed by the value of array.
//
// Output:
//
// Print the maximum difference of the indexes i and j in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 1000
// 0 ≤ A[i] ≤ 100
//
// Example:
//
// Input
// 1
// 2
// 1 10
// Output
// 1

package com.jsanghvi.online_problems.geeksforgeeks.hard;

import java.util.Scanner;

public class P0129_MaximumIndex {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumIndex(A);
        }
    }

    private static void printMaximumIndex(final int[] numbers) {
        final int[] maximumsOnRight = new int[numbers.length];

        int maximumOnRight = Integer.MIN_VALUE;
        for (int i = numbers.length - 1; i >= 0; i--) {
            maximumOnRight = Math.max(maximumOnRight, numbers[i]);
            maximumsOnRight[i] = maximumOnRight;
        }

        int minimumOnLeft = Integer.MAX_VALUE;
        int maximumIndex = 0;

        for (int i = 0, j = 0; i < numbers.length && j < numbers.length; ) {
            minimumOnLeft = Math.min(minimumOnLeft, numbers[i]);
            if (minimumOnLeft <= maximumsOnRight[j]) {
                maximumIndex = Math.max(maximumIndex, j - i);
                j += 1;
            } else {
                i += 1;
            }
        }

        System.out.println(maximumIndex);
    }
}
