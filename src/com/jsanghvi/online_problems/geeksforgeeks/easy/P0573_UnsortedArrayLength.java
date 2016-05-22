// Problem ID: 573. Unsorted array length.
//
// Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this
// subarray makes the whole array sorted.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N; N is the size of array.
// The second line of each test case contains N input arr[i].
//
// Output:
// Print the minimum length subarray arr[s..e]
//
// Constraints:
// 1 ≤ T ≤ 80
// 1 ≤ N ≤ 100
// 1 ≤ C[i] ≤ 500
//
// Example:
//
// Input
// 2
// 11
// 10 12 20 30 25 40 32 31 35 50 60
// 9
// 0 1 15 25 6 7 30 40 50
//
// Output
// 3 8
// 2 5

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0573_UnsortedArrayLength {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printUnsortedArray(A);
        }
    }

    private static void printUnsortedArray(final int[] numbers) {
        final int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbers);

        // Following tricks are required to match geeksforgeeks output for already sorted numbers.
        int left, right;
        for (left = 0; left < numbers.length - 1 && numbers[left] == sortedNumbers[left]; left++) ;
        for (right = numbers.length - 1; right > Math.max(left - 1, 0) && numbers[right] == sortedNumbers[right]; right--)
            ;
        System.out.println(left + " " + right);
    }
}
