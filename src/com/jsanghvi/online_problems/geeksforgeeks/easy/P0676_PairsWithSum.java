// Problem ID: 676. Count pairs with given sum.
//
// Given an array of integers, and an integer  ‘K’ , find the count of pairs of elements in the array whose sum is equal
// to 'K'.
//
// Input:
// First line of the input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test
// case consists of two lines. First line of each test case contains 2 space separated integers N and K denoting the
// size of array and the sum respectively. Second line of each test case contains N space separated integers denoting
// the elements of the array.
//
// Output:
// Print the count of pairs of elements in the array whose sum is equal to the K.
//
// Constraints:
// 1 <= T <= 50
// 1 <= N <= 50
// 1 <= K <= 50
// 1 <= A[i] <= 100
//
// Example:
//
// Input
// 2
// 4 6
// 1 5 7 1
// 4 2
// 1 1 1 1
//
// Output
// 2
// 6

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0676_PairsWithSum {
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

            printPairsWithSum(A, K);
        }
    }

    private static void printPairsWithSum(final int[] numbers, final int sum) {
        int pairsWithSum = 0;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : numbers) {
            pairsWithSum += (counts.containsKey(sum - number) ? counts.get(sum - number) : 0);
            counts.put(number, (counts.containsKey(number) ? counts.get(number) : 0) + 1);
        }

        System.out.println(pairsWithSum);
    }
}
