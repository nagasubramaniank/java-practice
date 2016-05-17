// Problem ID: 413. Count distinct pairs with difference k.
//
// Given an integer array and a non-negative integer k, count all distinct pairs with difference equal to k, i.e.,
// A[i] - A[j] = k.
//
// Input:
// The first line of input consists number of the test cases. The description of T test cases is as follows:
// The first line of each test case contains the size of the array, the second line has the elements of the array and
// the third line consists of the difference k.
//
// Output:
// In each separate line print the number of times difference k exists between the elements of the array.
//
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ N,K ≤ 100
// 0 ≤ A[i] ≤ 10000
//
// Example:
//
// Input:
// 3
// 5
// 1 5 4 1 2
// 0
// 3
// 1 1 1
// 0
// 3
// 1 5 3
// 2
//
// Output:
// 1
// 1
// 2

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0413_PairsWithDifference {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            final int K = in.nextInt();
            printPairsWithDifference(A, K);
        }
    }

    private static void printPairsWithDifference(final int[] numbers, final int difference) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : numbers) {
            if (!counts.containsKey(number)) {
                counts.put(number, 0);
            }
            counts.put(number, counts.get(number) + 1);
        }

        int pairsWithDifference = 0;

        if (difference == 0) {
            for (int right : counts.keySet()) {
                if (counts.get(right) > 1) {
                    pairsWithDifference += 1;
                }
            }
        } else {
            for (int right : counts.keySet()) {
                if (counts.containsKey(right - difference)) {
                    pairsWithDifference += 1;
                }
            }
        }

        System.out.println(pairsWithDifference);
    }
}
