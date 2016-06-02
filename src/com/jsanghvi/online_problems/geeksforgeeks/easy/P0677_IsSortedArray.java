// Problem ID: 677. Inorder traversal and BST.
//
// Given an array, write a program that prints 1 if array represents inorder traversal of a BST, else prints 0.  Note
// that all keys in BST must be unique.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N, N is the size of array.
// The second line of each test case contains N input C[i].
//
// Output:
//
// Print 1 array represents BST, else 0.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 500
// 1 ≤ Keys in BST ≤ 1200
//
// Example:
//
// Input
// 3
// 5
// 10 20 30 40 50
// 6
// 90 80 100 70 40 30
// 3
// 1 1 2
//
//
// Output
// 1
// 0
// 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0677_IsSortedArray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printIsSortedArray(A);
        }
    }

    private static void printIsSortedArray(final int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] >= numbers[i + 1]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
