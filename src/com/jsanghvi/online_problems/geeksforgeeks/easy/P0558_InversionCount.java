// Problem ID: 558. Inversion of array.
//
// Given an array, find inversion count of array.
//
// Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already
// sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. Formally
// speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
//
// The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input C[i].
//
// Output:
// Print the inversion count of array.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100
// 1 ≤ C ≤ 500
//
// Example:
//
// Input:
// 1
// 5
// 2 4 1 3 5
//
// Output:
// 3

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0558_InversionCount {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printInversionCount(A);
        }
    }

    private static void printInversionCount(final int[] numbers) {
        final BinaryIndexTree binaryIndexTree = new BinaryIndexTree(500);
        long inversions = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            binaryIndexTree.update(numbers[i], 1);
            inversions += binaryIndexTree.sumUpTo(numbers[i] - 1);
        }

        System.out.println(inversions);
    }

    private static class BinaryIndexTree {
        private final int size;
        private final long[] tree;

        public BinaryIndexTree(final int size) {
            this.size = size;
            this.tree = new long[size + 1];
        }

        private long sumUpTo(final int index) {
            long sum = 0;
            for (int i = index + 1; i > 0; i -= (i & -i)) {
                sum += tree[i];
            }
            return sum;
        }

        private void update(final int index, final long value) {
            for (int i = index + 1; i <= size; i += (i & -i)) {
                tree[i] += value;
            }
        }
    }
}
