// Problem ID: 146. Search in a Rotated Array.
//
// Find the index of the element in a given sorted and rotated array such that it has no duplicate elements. If it does
// not exist print -1.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N depicting the size of array and next line followed by the value of array. Last line of each case consist of
// an integer value to be searched for in the rotated array.
//
// Output:
//
// Print the index of the element found in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100005
// 0 ≤ A[i] ≤ 100005
// 1 ≤ k ≤ 100005
//
// Example:
//
// Input
// 1
// 9
// 5 6 7 8 9 10 1 2 3
// 10
//
// Output
// 5

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0146_SearchRotatedArray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printLocation(A, in.nextInt());
        }
    }

    private static void printLocation(final int[] array, final int element) {
        for (int left = 0, right = array.length - 1; left <= right; ) {

            final int mid = (left + right) / 2;
            if (element == array[mid]) {
                System.out.println(mid);
                return;
            }

            if (array[left] < array[mid]) {
                if (array[left] <= element && element <= array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (array[mid] <= element && element <= array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(-1);
    }
}
