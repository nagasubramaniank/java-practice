// Problem ID: 434. Relative Sorting.
//
// Given two array A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those
// are in A2. For the elements not present in A2. Append them at last in sorted order.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is M and N,M is the number of elements in A1 and N is the number of elements in A2.
// The second line of each test case contains M elements.
// The third line of each test case contains N elements.
//
// Output:
// Print the sorted array according order defined by another array.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ M ≤ 50
// 1 ≤ N ≤ 10 & N ≤ M
// 1 ≤ A1[i], A2[i] ≤ 1000
//
// Example:
//
// Input:
// 1
// 11 4
// 2 1 2 5 7 1 9 3 6 8 8
// 2 1 8 3
//
// Output:
// 2 2 1 1 8 8 3 5 6 7 9

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P0434_RelativeSorting {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int M = in.nextInt(), N = in.nextInt();
            final int[] A1 = new int[M], A2 = new int[N];

            for (int i = 0; i < M; i++) {
                A1[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                A2[i] = in.nextInt();
            }

            printRelativeSort(A1, A2);
        }
    }

    private static void printRelativeSort(final int[] A1, final int A2[]) {
        Map<Integer, Integer> counts = new TreeMap<>();

        for (int i = 0; i < A1.length; i++) {
            if (!counts.containsKey(A1[i])) {
                counts.put(A1[i], 1);
            } else {
                counts.put(A1[i], counts.get(A1[i]) + 1);
            }
        }

        for (int i = 0; i < A2.length; i++) {
            if (counts.containsKey(A2[i])) {
                for (int count = 0; count < counts.get(A2[i]); count++) {
                    System.out.print(A2[i] + " ");
                }
                counts.remove(A2[i]);
            }
        }

        for (Map.Entry<Integer, Integer> countEntry : counts.entrySet()) {
            for (int count = 0; count < countEntry.getValue(); count++) {
                System.out.print(countEntry.getKey() + " ");
            }
        }

        System.out.println();
    }
}
