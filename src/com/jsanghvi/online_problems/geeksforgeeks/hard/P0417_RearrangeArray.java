// Problem ID: 417. Rearrange an array with O(1) extra space.
//
// Given an array arr[] of size n where every element is in range from 0 to n-1. Rearrange the given array so that
// arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.
//
// Input:
//
// First line contains an integer denoting the test cases 'T'. Every test case contains an integer value depicting size
// of array 'N' and N integer elements are to be inserted in the next line with spaces between them.
//
// Output:
//
// Print all elements of the array after rearranging, each separated by a space, in separate line for each test case.
//
// Constraints:
//
// 1 <= T <= 70
// 1 <= N <= 100
// 1 <= Arr[i] <= 100
// Arr[i] <= N
//
// Example:
//
// Input:
//
// 3
// 2
// 1 0
// 5
// 4 0 2 1 3
// 4
// 3 2 0 1
//
// Output:
//
// 0 1
// 3 4 2 0 1
// 1 0 3 2

package com.jsanghvi.online_problems.geeksforgeeks.hard;

import java.util.Scanner;

public class P0417_RearrangeArray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] Arr = new int[N];

            for (int i = 0; i < N; i++) {
                Arr[i] = in.nextInt();
            }

            printRearrangedArray(Arr);
        }
    }

    private static void printRearrangedArray(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += (array[array[i]] % 1000) * 1000;
        }

        boolean firstElement = true;
        for (int element : array) {
            if (firstElement) {
                firstElement = false;
            } else {
                System.out.print(" ");
            }

            System.out.print(element / 1000);
        }

        System.out.println();
    }
}
