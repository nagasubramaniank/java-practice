// Problem ID: 170. Find maximum of minimum for every window size in a given array.
//
// Given an integer array of size n, find the maximum of the minimums of every window size in the array. Note that
// window size varies from 1 to n.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of array. The second line contains N space-separated integers
// A1, A2, ..., AN denoting the elements of the array.
//
// Output:
// In each separate line print the array of numbers of size n for each of the considered window size 1, 2, ..., n
// respectively.
//
// Constraints:
// 1 <= T <= 30
// 1 <= N <= 100
// 1 <= A[i] <= 5000
//
// Example:
// Input:
// 2
// 7
// 10 20 30 50 10 70 30
// 3
// 10 20 30
//
// Output:
// 70 30 20 10 10 10 10
// 30 20 10
//
// Explanation:
//
// Input: arr[] = {10, 20, 30, 50, 10, 70, 30}
// Output: 70, 30, 20, 10, 10, 10, 10
//
// First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are
// {10}, {20}, {30}, {50}, {10}, {70} and {30}. Maximum of these minimums is 70.
//
// Second element in output indicates maximum of minimums of all windows of size 2. Minimums of windows of size 2 are
// {10}, {20}, {30}, {10}, {10}, and {30}. Maximum of these minimums is 30.
//
// Third element in output indicates maximum of minimums of all windows of size 3. Minimums of windows of size 3 are
// {10}, {20}, {10}, {10} and {10}. Maximum of these minimums is 20.

package com.jsanghvi.online_problems.geeksforgeeks.hard;

import java.util.Scanner;

public class P0170_MaximumOfMinimums {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumOfMinimums(A);
        }
    }

    private static void printMaximumOfMinimums(final int[] numbers) {
        final int[][] minimumsAtLength = new int[numbers.length][numbers.length];

        for (int length = 1; length <= numbers.length; length++) {

            int maximum = Integer.MIN_VALUE;
            for (int i = 0; i < numbers.length - length + 1; i++) {

                if (length == 1) {
                    minimumsAtLength[length - 1][i] = numbers[i];
                } else {
                    minimumsAtLength[length - 1][i] =
                            Math.min(minimumsAtLength[length - 2][i], minimumsAtLength[length - 2][i + 1]);
                }

                if (maximum < minimumsAtLength[length - 1][i]) {
                    maximum = minimumsAtLength[length - 1][i];
                }
            }

            System.out.print(maximum + " ");
        }
        System.out.println();
    }
}
