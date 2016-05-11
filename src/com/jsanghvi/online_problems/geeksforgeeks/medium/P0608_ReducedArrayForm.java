// Problem ID: 608. Convert an array to reduced form.
//
// Given an array with n distinct elements, convert the given array to a reduced form where all elements are in range
// from 0 to n-1. The order of elements is same, i.e., 0 is placed in place of smallest element, 1 is placed for second
// smallest element, … n-1 is placed for largest element.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N, where N is the size of array.
// The second line of each test case contains N input arr[i].
//
// Output:
//
// Print the reduced form of the array.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 200
// 1 ≤ arr[i] ≤ 500
//
// Example:
//
// Input:
// 2
// 3
// 10 40 20
// 5
// 5 10 40 30 20
//
// Output:
// 0 2 1
// 0 1 4 3 2

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P0608_ReducedArrayForm {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printReducedArrayForm(A);
        }
    }

    private static void printReducedArrayForm(final int[] array) {
        final Map<Integer, Integer> valueIndex = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            valueIndex.put(array[i], i);
        }

        final int[] reducedArray = new int[array.length];
        int rank = 0;
        for (int index : valueIndex.values()) {
            reducedArray[index] = rank++;
        }

        for (int number : reducedArray) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
