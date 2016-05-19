// Problem ID: 505. Array to BST.
//
// Given a sorted array. Write a program that creates a Balanced Binary Search Tree using array elements. If there are n
// elements in array, then floor(n/2)'th element should be chosen as root and same should be followed recursively.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input A[].
//
// Output:
// Print the pre-order traversal of constructed BST.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 1000
// 1 ≤ A[] ≤ 10000
//
// Example:
//
// Input:
// 1
// 7
// 7 6 5 4 3 2 1
//
// Output:
// 4 2 1 3 6 5 7

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0505_ArrayToBst {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printPreOrderOfBalancedBst(A);
        }
    }

    private static void printPreOrderOfBalancedBst(final int[] array) {
        Arrays.sort(array);
        final StringBuilder output = new StringBuilder();
        preOrderOfBalancedBst(array, 0, array.length - 1, output);
        System.out.println(output);
    }

    private static void preOrderOfBalancedBst(final int[] array, final int left, final int right,
                                              final StringBuilder output) {
        if (left > right) {
            return;
        }

        final int mid = (left + right) / 2;
        output.append(array[mid]).append(' ');

        preOrderOfBalancedBst(array, left, mid - 1, output);
        preOrderOfBalancedBst(array, mid + 1, right, output);
    }
}
