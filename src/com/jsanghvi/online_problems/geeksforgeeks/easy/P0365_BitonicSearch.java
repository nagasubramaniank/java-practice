// Problem ID: 365. Finding Number.
//
// An array is bitonic if it is comprises of an increasing sequence of integers followed immediately by a decreasing
// sequence of integers. Given such a array, you need to find a element X in it and print its index. In case, X does not
// exist in the array print "OOPS! NOT FOUND" without quotes.
//
// Note: It is guaranteed that array consist of distinct elements. And array indexing is from 0.
//
// Input:
// First line will consist  a number T, the number of test cases.
// Each test case will then consist of two numbers N and X. N being the array size and X being the element to be
// searched for.
// Next line will consist of N space separated integers.
//
// Output:
// Print the required answer on separate lines.
//
// Constraints:
// 1 <= T <= 10
// 1 <= N <= 200
// -100 <= A[i] <= 100
//
// Example:
//
// Input:
// 1
// 5 2
// 1 2 7 3 4
//
// Output:
// 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0365_BitonicSearch {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int V = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printBitonicSearch(A, V);
        }
    }

    private static void printBitonicSearch(final int[] array, final int value) {
        final int pivot = bitonicPivotIndex(array);

        int index;
        if ((index = binarySearch(array, 0, pivot - 1, value, false)) >= 0
                || (index = binarySearch(array, pivot, array.length - 1, value, true)) >= 0) {
            System.out.println(index);
        } else {
            System.out.println("OOPS! NOT FOUND");

        }
    }

    private static int bitonicPivotIndex(final int[] array) {
        for (int left = 0, right = array.length - 1; left <= right; ) {
            final int mid = ((left + right) / 2);
            if (mid != left && array[mid - 1] > array[mid]) {
                right = mid - 1;
            } else if (mid != right && array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static int binarySearch(final int[] array, int left, int right, final int value, final boolean descending) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((array[mid] == value)) {
                return mid;
            } else if (array[mid] < value ^ descending) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
