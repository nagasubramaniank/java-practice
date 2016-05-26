// Problem ID: 732. Triplet sum in array.
//
// Given an array A[] of n numbers and another number x, determine whether or not there exist three elements in A[]
// whose sum is exactly x. Expected time complexity is O(n^2).
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is n and x, n is the size of array.
// The second line of each test case contains n integers representing array elements C[i].
//
// Output:
//
// Print 1 if there exist three elements in A whose sum is exactly x, else 0.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 200
// 1 ≤ A[i] ≤ 1000
//
// Example:
//
// Input:
// 2
// 6 13
// 1 4 45 6 10 8
// 5 10
// 1 2 4 3 6
//
// Output:
// 1
// 1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0732_TripletSum {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int X = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printIsTripletSum(A, X);
        }
    }

    private static void printIsTripletSum(final int[] integers, final int expectedSum) {
        Set<Integer> tupleSums = new HashSet<>();

        for (int i = 0; i < integers.length; i++) {
            if (tupleSums.contains(expectedSum - integers[i])) {
                System.out.println(1);
                return;
            }

            for (int j = 0; j < i; j++) {
                tupleSums.add(integers[i] + integers[j]);
            }
        }

        System.out.println(0);
    }
}
