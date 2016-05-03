// Problem ID: 188. Longest Span with same Sum in two Binary arrays.
//
// Given two binary arrays arr1[] and arr2[] of same size n. Find length of the longest common span (i, j) where j >= i
// such that arr1[i] + arr1[i+1] + …. + arr1[j] = arr2[i] + arr2[i+1] + …. + arr2[j]. Elements are only 0 or 1.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of array. The second line contains N space-separated integers
// A1, A2, ..., AN denoting the elements of the array. The third line contains N space-separated integers
// B1, B2, ..., BN denoting the elements of the array.
//
// Output:
// In each separated line output the maximum span with same sum.
//
// Constraints:
// 1 <= T <= 31
// 1 <= N <= 100
//
// Example:
// Input:
// 1
// 6
// 0 1 0 0 0 0
// 1 0 1 0 0 1
//
// Output:
// 4
//
// Explanation:
// The longest span with same sum is from index 1 to 4  (Zero indexing).

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0188_LongestCommonSpan {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];
            final int[] B = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                B[i] = in.nextInt();
            }

            printLongestCommonSpan(A, B);
        }
    }

    private static void printLongestCommonSpan(final int[] A, final int[] B) {

        // Stores the smallest index when a particular difference was hit.
        final Map<Integer, Integer> firstDifference = new HashMap<>();

        int difference = 0;
        firstDifference.put(0, -1);
        int longestSpan = 0;

        for (int i = 0; i < A.length; i++) {
            difference += A[i] - B[i];

            if (!firstDifference.containsKey(difference)) {
                firstDifference.put(difference, i);
            }

            longestSpan = Math.max(longestSpan, i - firstDifference.get(difference));
        }

        System.out.println(longestSpan);
    }
}
