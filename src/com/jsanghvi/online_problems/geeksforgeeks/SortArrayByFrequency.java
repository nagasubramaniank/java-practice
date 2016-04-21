// Problem ID: 493. Sorting Elements of an Array by Frequency.
//
// Given an array of integers, sort the array according to frequency of elements. For example, if the input array is
// {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}, then modify the array to {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}.
//
// If frequencies of two elements are same, print them in increasing order.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. The first line of each test case contains a single integer N denoting the size of array. The second line
// contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
// Output:
//
// Print each sorted array in a separate line. For each array its numbers should be separated by space.
//
// Constraints:
//
// 1 ≤ T ≤ 70
// 30 ≤ N ≤ 130
// 1 ≤ A [ i ] ≤ 60
//
// Example:
//
// Input:
//
// 1
// 5
// 5 5 4 6 4
//
// Output:
//
// 4 4 5 5 6

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrayByFrequency {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();

            final int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printArraySortedByFrequency(A);
        }
    }

    private static void printArraySortedByFrequency(int[] array) {
        ValueFrequency[] frequencies = new ValueFrequency[60];

        for (int value = 0; value < 60; value++) {
            frequencies[value] = new ValueFrequency(value);
        }

        for (int value : array) {
            frequencies[value].frequency += 1;
        }

        Arrays.sort(frequencies);

        boolean isFirstValue = true;
        for (ValueFrequency valueFrequency : frequencies) {
            for (int j = 0; j < valueFrequency.frequency; j++) {

                if (isFirstValue) {
                    isFirstValue = false;
                } else {
                    System.out.print(" ");
                }

                System.out.print(valueFrequency.value);
            }
        }

        System.out.println();
    }

    private static class ValueFrequency implements Comparable<ValueFrequency> {
        private final int value;
        private int frequency;

        public ValueFrequency(final int value) {
            this.value = value;
        }

        @Override
        public int compareTo(ValueFrequency that) {
            if (this.frequency != that.frequency) {
                return that.frequency - this.frequency; // Higher frequency comes earlier.
            }

            return this.value - that.value; // Lower value comes earlier.
        }
    }
}
