// Problem ID: 240. Sum of Middle Elements of two sorted arrays.
//
// Given 2 sorted arrays A and B of size N each. Print sum of middle elements of the array obtained after merging the
// given arrays.
//
// Input:
// The first line contains 'T' denoting the number of test cases. Then follows description of test cases.
// Each case begins with a single positive integer N denoting the size of array.
// The second line contains the N space separated positive integers denoting the elements of array A.
// The third line contains N space separated positive integers denoting the elements of array B.
//
// Output:
// For each test case, print the sum of middle elements of two sorted arrays. The number of the elements in the merged
// array are even so there will be 2 numbers in the center n/2 and n/2 + 1. You have to print their sum.
//
// Constraints:
// 1 <= T <= 50
// 1 <= N <= 1000
// 1 <= A[i] <= 100000
// 1 <= B[i] <= 100000
//
// Example:
//
// Input:
// 1
// 5
// 1 2 4 6 10
// 4 5 6 9 12
//
// Output:
// 11

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0240_MergedArrayMedian {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N], B = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                B[i] = in.nextInt();
            }

            printMedian(A, B);
        }
    }

    private static void printMedian(final int[] array1, final int[] array2) {

        for (int left1 = 0, left2 = 0, length = array1.length; length > 0; length = (length + 1) / 2) {
            if (length % 2 != 0) {
                final int mid1 = left1 + length / 2, mid2 = left2 + length / 2;

                if (length == 1 || array1[mid1] == array2[mid2]) {
                    System.out.println(array1[mid1] + array2[mid2]);
                    return;
                } else if (array1[mid1] < array2[mid2]) {
                    left1 = mid1;
                } else {
                    left2 = mid2;
                }
            } else {
                final int mid11 = left1 + length / 2 - 1, mid12 = left1 + length / 2;
                final int mid21 = left2 + length / 2 - 1, mid22 = left2 + length / 2;

                if (length == 2 || (array1[mid11] <= array2[mid22] && array2[mid21] <= array1[mid12])) {
                    System.out.println(Math.max(array1[mid11], array2[mid21]) + Math.min(array1[mid12], array2[mid22]));
                    return;
                } else if (array1[mid12] < array2[mid21]) {
                    left1 = mid12;
                } else {
                    left2 = mid22;
                }
            }
        }
    }
}
