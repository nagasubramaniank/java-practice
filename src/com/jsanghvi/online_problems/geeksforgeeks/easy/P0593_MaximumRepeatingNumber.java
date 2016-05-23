// Problem ID: 593. Maximum repeating number.
//
// Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n.
// Find the maximum repeating number in this array. For example, let k be 10 the given array be
// arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, the maximum repeating number would be 2 if there are two or more
// maximum repeating numbers print the element having least value (See last sample case for the more clarifications).
// Expected time complexity is O(n) and extra space allowed is O(1).
//
// Input:
// The first line of input contains an integer T, denoting the number of test cases. First line of each test case
// contains n and k. Next line contains n integers of array.
//
// Output:
// Print the output for each test case in a separate line.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= k <= N
// 0 <= a[i] <= k-1
//
// Example:
//
// Input:
// 2
// 4 3
// 2 2 1 2
// 6 3
// 2 2 1 0 0 1
//
// Output:
// 2
// 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0593_MaximumRepeatingNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            in.nextInt();

            final int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumRepeatingNumber(A);
        }
    }

    private static void printMaximumRepeatingNumber(final int[] numbers) {
        final int maximum = numbers.length;
        int maximumRepeatingNumber = -1;
        int maximumRepetitions = 0;

        for (final int number : numbers) {
            final int repeatingNumber = number % maximum;
            numbers[repeatingNumber] += maximum;
            final int repetitions = numbers[repeatingNumber] / maximum;

            if (maximumRepetitions < repetitions
                    || (maximumRepetitions == repetitions && maximumRepeatingNumber > repeatingNumber)) {
                maximumRepetitions = repetitions;
                maximumRepeatingNumber = repeatingNumber;
            }
        }

        System.out.println(maximumRepeatingNumber);
    }
}
