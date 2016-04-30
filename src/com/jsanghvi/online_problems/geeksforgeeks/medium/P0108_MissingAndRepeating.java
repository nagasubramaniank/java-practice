// Problem ID: 108. Find Missing And Repeating.
//
// Given an unsorted array of size n. Array elements are in range from 1 to n. One number 'A' from set {1, 2, …, n} is
// missing and one number 'B' occurs twice in array. Find these two numbers.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows.
// The first line of each test case contains a single integer N denoting the size of array.
// The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
// Output:
//
// Print B, the repeating number followed by A which is missing in a single line.
//
// Constraints:
//
// 1 ≤ T ≤ 40
// 1 ≤ N ≤ 100
// 1 ≤ A[i] ≤ N
//
// Example:
//
// Input
// 2
// 2
// 2 2
// 3
// 1 3 3
//
// Output
// 2 1
// 3 2

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0108_MissingAndRepeating {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMissingAndRepeating(A);
        }
    }

    private static void printMissingAndRepeating(final int[] numbers) {

        int total = 0, squaredTotal = 0;

        for (int number : numbers) {
            total += number;
            squaredTotal += number * number;
        }

        final int N = numbers.length;
        int difference = total - (N * (N + 1)) / 2;
        int squaredDifference = squaredTotal - (N * (N + 1) * (2 * N + 1)) / 6;
        int sum = squaredDifference / difference;

        System.out.println((sum + difference) / 2 + " " + (sum - difference) / 2);
    }
}
