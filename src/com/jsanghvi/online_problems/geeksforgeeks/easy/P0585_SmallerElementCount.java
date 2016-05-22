// Problem ID: 585. Count smaller elements.
//
// Write a program for count number of smaller elements on right of each element in an array. Given an unsorted array
// arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains count of
// smaller elements on right side of each element arr[i] in array.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input arr[i].
//
// Output:
// Print the countSmaller array.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 200
// 1 ≤ C[i] ≤ 500
//
// Example:
//
// Input:
// 2
// 7
// 12 1 2 3 0 11 4
// 5
// 1 2 3 4 5
//
// Output:
// 6 1 1 1 0 1 0
// 0 0 0 0 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0585_SmallerElementCount {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printSmallerElementCount(A);
        }
    }

    private static void printSmallerElementCount(final int[] elements) {
        final int[] smallerElementCount = new int[elements.length];
        final BinaryIndexTree binaryIndexTree = new BinaryIndexTree(500);

        for (int i = elements.length - 1; i >= 0; i--) {
            binaryIndexTree.update(elements[i], 1);
            smallerElementCount[i] = binaryIndexTree.sumUpTo(elements[i] - 1);
        }

        for (int i = 0; i < elements.length; i++) {
            System.out.print(smallerElementCount[i] + " ");
        }
        System.out.println();
    }

    private static class BinaryIndexTree {
        private final int size;
        private final int[] tree;

        public BinaryIndexTree(final int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        private int sumUpTo(final int index) {
            int sum = 0;
            for (int i = index + 1; i > 0; i -= (i & -i)) {
                sum += tree[i];
            }
            return sum;
        }

        private void update(final int index, final int value) {
            for (int i = index + 1; i <= size; i += (i & -i)) {
                tree[i] += value;
            }
        }
    }
}
