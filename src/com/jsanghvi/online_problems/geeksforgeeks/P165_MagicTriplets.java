// Problem ID: 160. Magic Triplets.
//
// Given an array a[] of n integers, a triplet (a[i], a[j], a[k]) is called Magic Triplet if a[i] < a[j] < a[k] and
// i < j < k.  The task is to count number of magic triplets in a given array.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of array. The second line contains N space-separated integers
// A1, A2, ..., AN denoting the elements of the array.
//
// Output:
// In each separate line print the number of such triplets.
//
// Constraints:
// 1 <= T <= 31
// 1 <= N <= 10000
// 1 <= A[i] <= 5000
//
// Example:
//
// Input:
// 2
// 3
// 3 2 1
// 4
// 1 2 3 4
//
// Output:
// 0
// 4

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Scanner;

public class P165_MagicTriplets {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printNumMagicTriplets(A);
        }
    }

    private static void printNumMagicTriplets(final int[] array) {

        BinaryIndexTree tupletBin = new BinaryIndexTree(5000);
        BinaryIndexTree tripletBin = new BinaryIndexTree(5000);

        long numTriplets = 0;
        for (int number : array) {
            tupletBin.update(number, 1);
            tripletBin.update(number, tupletBin.sumUpTo(number - 1));
            numTriplets += tripletBin.sumUpTo(number - 1);
        }

        System.out.println(numTriplets);
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
