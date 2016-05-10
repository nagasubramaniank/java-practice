// Problem ID: 578. Maximum length Bitonic Subarray.
//
// Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic if there is a k with
// i <= k <= j such that A[i] < A[i + 1] ... < A[k] > A[k + 1] > .. A[j – 1] >  A[j]. Write a program that returns the
// length of the maximum length bitonic subarray.
//
// For Example: In array {20, 4, 1, 2, 3, 4, 2, 10} the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of
// length 5.
//
// Note: A[k] can be first or last element. Ex:-  10 20 30 , 30 20 10 and 1 2 3 4 3 2 1 these all are bitonic array.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input A[i].
//
// Output:
//
// Print the maximum length of bitonic subarray.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 200
// 1 ≤ A[i] ≤ 1000
//
// Example:
//
// Input:
// 2
// 6
// 12 4 78 90 45 23
// 4
// 10 20 30 40
//
// Output:
// 5
// 4

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0578_BitonicArray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printBitonicLength(A);
        }
    }

    private static void printBitonicLength(final int[] array) {
        int maxLength = 0, currentLength = 0;
        int previousElement = 0;
        boolean upwards = true;

        for (int element : array) {
            if (previousElement <= element) {
                if (!upwards || previousElement == element) {
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = (previousElement == element ? 0 : 1);
                }
                upwards = true;
            } else {
                upwards = false;
            }
            currentLength += 1;
            previousElement = element;
        }

        maxLength = Math.max(maxLength, currentLength);
        System.out.println(maxLength);
    }
}
