// Problem ID: 445. Remove minimum elements.
//
// Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array.
// Elements should be removed either end of the array. Number of removals should be minimum.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input A[i], numbers in array.
//
// Output:
// Print the minimum number of removals.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 1000
// 1 ≤ A[i] ≤ 1000
//
// Example:
//
// Input
// 1
// 9
// 4 5 100 9 10 11 12 15 200
//
// Output
// 4

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0445_RemoveElements {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printTotalRemovals(A);
        }
    }

    private static void printTotalRemovals(final int[] array) {
        int longestSequence = 0;

        // There's no need to look for subarrays smaller than the found sequence that honors the condition.
        for (int left = 0; left < array.length - longestSequence; left++) {
            int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE;

            for (int right = left; right < array.length; right++) {
                minimum = Math.min(minimum, array[right]);
                maximum = Math.max(maximum, array[right]);

                // If A[left..right] does not honor the condition, A[left..right+] would also not.
                if (2 * minimum <= maximum) {
                    break;
                }

                longestSequence = Math.max(longestSequence, right - left + 1);
            }
        }

        System.out.println(array.length - longestSequence);
    }
}
