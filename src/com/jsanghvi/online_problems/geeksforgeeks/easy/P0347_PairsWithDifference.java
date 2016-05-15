// Problem ID: 347. Pairs with difference k.
//
// Given an array of N positive integers  a1, a2 ..... an. Find the number of pairs of integers whose difference is
// equal to a given number K.
//
// Input:
// The first line of the input contains 'T' denoting the total number of test cases.Then follows the description of test
// cases. The first line of each test case contains two space separated positive integers N and K denoting the size of
// array and the value of K. The second line contains N space separated positive integers denoting the elements of array.
//
// Output:
// Output the number of pairs having difference equal to K in a separate line.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 1 <= K <= 100
// 1 <= Arr[i] <= 1000
//
// Example:
//
// Input
// 2
// 5 2
// 6 4 5 8 7
// 4 2
// 1 3 1 8
//
// Output
// 3
// 2

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0347_PairsWithDifference {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int K = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

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
        for (int right : counts.keySet()) {
            if (counts.containsKey(right - difference)) {
                pairsWithDifference += counts.get(right) * counts.get(right - difference);
            }
        }

        System.out.println(pairsWithDifference);
    }
}
