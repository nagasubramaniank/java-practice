// Problem ID: 341. Sort an array of 0s, 1s and 2s.
//
// Write a program to sort an array of 0's, 1's and 2's in ascending order.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is
// number of elements in array 'N' and second its values.
//
// Output:
// Print the sorted array of 0's, 1's and 2's.
//
// Constraints:
//
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= arr[i] <= 2
//
// Example:
//
// Input:
// 2
// 5
// 0 2 1 2 0
// 3
// 0 1 0
//
// Output:
// 0 0 1 2 2
// 0 0 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0341_SortArray012 {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printSortedArray(A);
        }
    }

    private static void printSortedArray(final int[] numbers) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int number : numbers) {
            switch (number) {
                case 0:
                    count0 += 1;
                    break;
                case 1:
                    count1 += 1;
                    break;
                case 2:
                    count2 += 1;
                    break;
            }
        }

        StringBuilder output = new StringBuilder();

        for (int count = 0; count < count0; count++) {
            output.append(0).append(' ');
        }

        for (int count = 0; count < count1; count++) {
            output.append(1).append(' ');
        }

        for (int count = 0; count < count2; count++) {
            output.append(2).append(' ');
        }

        System.out.println(output);
    }
}
