// Problem ID: 670. Palindromic Array.
//
// You are given an array A of size N. Your task is to find the minimum number of operations needed to convert the given
// array to 'Palindromic Array'.
//
// Palindromic Array:
// [23,15,23] is a ‘Palindromic Array’ but [2,0,1] is not.
//
// The only allowed operation is that you can merge two adjacent elements in the array and replace them with their sum.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N, where N is the size of array.
// The second line of each test case contains N space separated integers which is the input for the array.
//
// Output:
// Output the minimum number of operations required to make the given array a palindromic array.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
//
// Example:
//
// Input:
// 2
// 5
// 3 2 3 3 5
// 4
// 5 3 3 4
//
// Output:
// 1
// 3
//
// Explanation:
// For Test Case 1: [3 2 3 3 5] after merging the 1st two elements 3 and 2, we get the array as [5 3 3 5] which is a palindrome, hence only 1 operation is needed.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0670_PalindromeOperations {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printTotalOperations(A);
        }
    }

    private static void printTotalOperations(final int[] array) {
        int totalOperations = 0;
        for (int left = 0, right = array.length - 1, sumLeft = array[left], sumRight = array[right]; left < right; ) {
            if (sumLeft == sumRight) {
                sumLeft += array[++left];
                sumRight += array[--right];
            } else {
                totalOperations += 1;

                if (sumLeft < sumRight) {
                    sumLeft += array[++left];
                } else {
                    sumRight += array[--right];
                }
            }
        }

        System.out.println(totalOperations);
    }
}
