// Problem ID: 134. Longest Increasing Subsequence.
//
// Given a sequence, find the length of the longest subsequence of a given sequence . The longest increasing subsequence
// means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to
// highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or
// unique.
//
// For example: Length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N depicting the size of array and next line followed by the value of array.
//
// Output:
//
// Print the maximum length of the subsequence in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 40
// 1 ≤ N ≤ 1000
// 0 ≤ A[i] ≤ 300
//
// Example:
//
// Input
// 1
// 16
// 0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
//
// Output
// 6

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0134_LongestIncreasingSubsequence {
    public static void main(final String[] args) {

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printLongestIncreasingSubsequence(A);
        }
    }

    private static void printLongestIncreasingSubsequence(final int[] sequence) {

        // M[i] stores smallest number (found so far) required to construct subsequence of length i.
        final int[] M = new int[sequence.length + 1];

        int longestLengthAll = 0;

        for (int number : sequence) {

            // Search for largest j such that M[j] < sequence[i].
            int longestLengthTill = binarySearch(number, M, 1, longestLengthAll) + 1;
            M[longestLengthTill] = number;
            longestLengthAll = Math.max(longestLengthAll, longestLengthTill);
        }

        System.out.println(longestLengthAll);
    }

    private static int binarySearch(final int number, final int[] sequence, final int low, final int high) {

        int mid = (low + high) / 2;
        if (sequence[mid] < number) {
            if (mid >= high) {
                return mid;
            }
            return binarySearch(number, sequence, mid + 1, high);
        } else {
            if (mid <= low) {
                return low - 1;
            }
            return binarySearch(number, sequence, low, mid - 1);
        }
    }
}
