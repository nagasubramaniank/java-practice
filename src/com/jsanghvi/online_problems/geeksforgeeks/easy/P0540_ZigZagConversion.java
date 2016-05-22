// Problem ID: 540. Convert array into zig-zag fashion.
//
// Problem Description:
// Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted
// array should be in form a < b > c < d > e < f.The relative order of elements is same in the output i.e you have to
// iterate on the original array only.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows.
// The first line of each test case contains a single integer N denoting the size of array.
// The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
// Output:
// Print the array in Zig-Zag fashion.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100
// 0 ≤ A[i] ≤ 10000
//
// Example:
//
// Input:
// 2
// 7
// 4 3 7 8 6 2 1
// 4
// 1 4 3 2
//
// Output:
// 3 7 4 8 2 6 1
// 1 4 2 3

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0540_ZigZagConversion {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printZigZagConversion(A);
        }
    }

    private static void printZigZagConversion(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (i % 2 == 0 ^ array[i] < array[i + 1]) {
                swap(array, i, i + 1);
            }
        }

        for (final int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void swap(final int[] array, final int index1, final int index2) {
        final int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
