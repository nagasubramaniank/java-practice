// Problem ID: 451. Maximum of all subarrays of size k.
//
// Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. The first line of each test case contains a single integer 'N' denoting the size of array and the size of
// subarray 'k'. The second line contains 'N' space-separated integers A1, A2, ..., AN denoting the elements of the
// array.
//
// Output:
// Print the maximum for every subarray of size k.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100
// 1 ≤ k ≤ N
// 0 ≤ A[i] < 1000
//
// Example:
//
// Input:
// 2
// 9 3
// 1 2 3 1 4 5 2 3 6
// 10 4
// 8 5 10 7 9 4 15 12 90 13
//
// Output:
// 3 3 4 5 5 5 6
// 10 10 10 15 15 90 90

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class P0451_MaximumOfSubarrays {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int K = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumOfSubarrays(A, K);
        }
    }

    private static void printMaximumOfSubarrays(final int[] array, final int subarraySize) {
        final StringBuilder output = new StringBuilder();
        final Queue<Integer> subarray = new PriorityQueue<>(subarraySize, Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            if (i >= subarraySize) {
                subarray.remove(array[i - subarraySize]);
            }

            subarray.add(array[i]);

            if (i >= subarraySize - 1) {
                output.append(subarray.peek()).append(' ');
            }
        }

        System.out.println(output);
    }
}
