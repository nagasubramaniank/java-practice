// Problem ID: 719. Preorder traversal and BST.
//
// Given an array, write a program that prints 1 if given array can represent preorder traversal of a BST, else prints 0.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N; N is the size of array.
// The second line of each test case contains N input A[i].
//
// Output:
// Should print 1 if given array can represent preorder traversal of BST. Otherwise 0.
//
// Constraints:
// 1 <= T <= 55
// 1 <= N <= 1000
// 1 <= arr[i] <= 1000
//
// Example:
//
// Input:
// 3
// 5
// 40 30 35 80 100
// 8
// 40 30 32 35 80 90 100 120
// 8
// 7 9 6 1 4 2 3 40
//
// Output:
// 1
// 1
// 0

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0719_PreorderValidation {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printIsValidPreorder(A);
        }
    }

    private static void printIsValidPreorder(final int[] preorder) {
        System.out.println(isValidPreorder(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE)
                ? 1 : 0);
    }

    private static boolean isValidPreorder(final int[] preorder, final int left, final int right, final int minimum,
                                           final int maximum) {
        if (left > right) {
            return true;
        }

        int root = preorder[left];
        int pivot = right + 1;
        for (int i = left + 1; i <= right; i++) {
            if (preorder[i] > root) {
                pivot = i;
                break;
            }
        }

        return (root >= minimum && root <= maximum && isValidPreorder(preorder, left + 1, pivot - 1, minimum, root)
                && isValidPreorder(preorder, pivot, right, root, maximum));
    }
}
