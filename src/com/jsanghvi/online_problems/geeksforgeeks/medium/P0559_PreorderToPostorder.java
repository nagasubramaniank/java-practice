// Problem ID: 559. Preorder to Postorder.
//
// Given an array representing preorder traversal of BST, print its postorder traversal.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input A[i].
//
// Output:
// Postorder traversal of the given preorder traversal is printed. Otherwise 'NO' is printed.
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
// 35 30 100 80 40
// 35 32 30 120 100 90 80 40
// NO

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Arrays;
import java.util.Scanner;

public class P0559_PreorderToPostorder {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printPostorder(A);
        }
    }

    // Create a tree instead of working directly on preorder sequence. We need to fail beforehand without printing
    // anything if post-order is not possible.

    private static void printPostorder(final int[] preorder) {
        TreeNode root = constructBst(preorder);
        if (!Arrays.equals(preorder, generatePreorder(root, preorder.length))) {
            System.out.println("NO");
        } else {
            printPostorder(root);
            System.out.println();
        }
    }

    private static TreeNode constructBst(final int[] preorder) {
        TreeNode root = null;

        for (int number : preorder) {
            root = insert(root, number);
        }

        return root;
    }

    private static TreeNode insert(final TreeNode node, final int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value <= node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    private static int[] generatePreorder(final TreeNode root, final int size) {
        final int[] preorder = new int[size];
        preorderTraversal(root, preorder, 0);
        return preorder;
    }

    private static int preorderTraversal(final TreeNode node, final int[] preorder, final int next) {
        if (node == null) {
            return next;
        }

        preorder[next] = node.value;
        return preorderTraversal(node.right, preorder, preorderTraversal(node.left, preorder, next + 1));
    }

    private static void printPostorder(final TreeNode node) {
        if (node == null) {
            return;
        }

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.value + " ");
    }

    private static class TreeNode {
        final int value;
        TreeNode left, right;

        TreeNode(final int value) {
            this.value = value;
        }
    }
}
