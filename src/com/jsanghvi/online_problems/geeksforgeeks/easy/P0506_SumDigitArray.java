// Problem ID: 506. Sum of two numbers represented by an array.
//
// Given two numbers represented by two arrays, write a function that returns sum array. The sum array is an array
// representation of addition of two input arrays. It is not allowed to modify the arrays.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case contains two integers M and N separated by a space. M is the size of arr1 and N
// is the size of arr2.
// The second line of each test case contains M integers which is the input for arr1.
// The third line of each test case contains N integers which is the input for arr2.
//
// Output:
// Print the sum list.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ M ≤ 1000
// 0 ≤ arr1[i],arr2[i]≤ 9
//
// Example:
//
// Input:
// 2
// 3 3
// 5 6 3
// 8 4 2
// 16 4
// 2 2 7 5 3 3 7 3 3 6 8 3 0 5 0 6
// 4 3 3 8
//
// Output:
// 1 4 0 5
// 2 2 7 5 3 3 7 3 3 6 8 3 4 8 4 4

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0506_SumDigitArray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int M = in.nextInt(), N = in.nextInt();
            final int[] A1 = new int[M], A2 = new int[N];

            for (int i = 0; i < M; i++) {
                A1[M - i - 1] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                A2[N - i - 1] = in.nextInt();
            }

            printSumArray(A1, A2);
        }
    }

    private static void printSumArray(final int[] array1, final int[] array2) {
        StringBuilder output = new StringBuilder();

        int carry = 0;

        for (int i = 0; i < array1.length; i++) {
            final int sum = array1[i] + (i < array2.length ? array2[i] : 0) + carry;
            output.insert(0, (sum % 10) + " ");
            carry = sum / 10;
        }

        if (carry != 0) {
            output.insert(0, carry + " ");
        }

        System.out.println(output);
    }
}
