// Problem ID: 189. Maximize number of 1s.
//
// Given a binary array and an integer m, find the maximum number of consecutive 1's produced by flipping 0's. You can
// flip maximum m zeroes.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of array. The second line contains N space-separated integers
// A1, A2, ..., AN denoting the elements of the array.  Third line consists of an integer m that is maximum number of
// flips allowed.
//
// Output:
// Output the maximum numbers of consecutive 1's. (Indices begin from 0).
//
// Constraints:
// 1 <= T <= 31
// 1 <= N <= 100
// 1 <= m <= N
//
// Example:
//
// Input:
// 1
// 11
// 1 0 0 1 1 0 1 0 1 1 1
// 2
//
// Output:
// 8
//
// Explanation:
//
// Input:
// arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
// m = 2
// Output:  8
//
// We are allowed to flip maximum 2 zeroes. If we flip arr[5] and arr[7], we get 8 consecutive 1's which is maximum
// possible under given constraints

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0189_MaximizeOnes {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final boolean[] A = new boolean[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt() != 0;
            }

            printMaximumLength(A, in.nextInt());
        }
    }

    private static void printMaximumLength(final boolean[] array, final int flips) {
        int maximumLength = 0;
        int remainingFlips = flips;

        for (int left = 0, right = 0; right < array.length; right++) {
            if (array[right]) {
                maximumLength = Math.max(maximumLength, right - left + 1);
            } else if (remainingFlips > 0) {
                remainingFlips -= 1;
                maximumLength = Math.max(maximumLength, right - left + 1);
            } else {
                // Skip one zero
                for (; array[left]; left++)
                    ;

                left += 1;
            }
        }

        System.out.println(maximumLength);
    }
}
