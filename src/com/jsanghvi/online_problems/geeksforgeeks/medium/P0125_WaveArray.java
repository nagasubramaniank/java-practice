// Problem ID: 125. Wave Array.
//
// Given an array of integers, sort the array into a wave like array and return it. In other words, arrange the elements
// into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
//
// Example
//
// Given [1, 2, 3, 4]
//
// One possible answer : [2, 1, 4, 3]
// Another possible answer : [4, 1, 3, 2]
// NOTE : If there are multiple answers possible, return the one that is lexicographically smallest.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N depicting the size of the array and next line followed by the value of array.
//
// Output:
//
// Print the array into wave like array.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 100
// 0 ≤ A[i] ≤ 100
//
// Example:
//
// Input
// 1
// 5
// 5 7 3 2 8
//
// Output
// 3 2 7 5 8


package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Arrays;
import java.util.Scanner;

public class P0125_WaveArray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printInWaveFormat(A);
        }
    }

    private static void printInWaveFormat(int[] array) {
        Arrays.sort(array);

        for (int i = 0; i + 1 < array.length; i += 2) {
            System.out.print(array[i + 1] + " " + array[i] + " ");
        }

        if (array.length % 2 == 1) {
            System.out.print(array[array.length - 1]);
        }

        System.out.println();
    }
}
