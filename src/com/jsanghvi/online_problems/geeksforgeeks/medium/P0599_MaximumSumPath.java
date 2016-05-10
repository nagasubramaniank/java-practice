// Problem ID: 599. Maximum Sum Path in Two Arrays.
//
// Given two sorted arrays such the arrays may have some common elements, find the sum of the maximum sum path to reach
// from beginning of any array to end of any of the two arrays. We can start from any array and switch from one array to
// another array only at common elements.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows.
// The first line of each test case contains two integers M and N denoting the size of two arrays.
// Then two lines follow, first containing M space-separated integers A1, A2, ..., AM denoting the elements of the array
// and second containing N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
// Output:
// Print the maximum sum.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= A[i] <= 100
//
// Example:
//
// Input:
// 2
// 8 8
// 2 3 7 10 12 15 30 34
// 1 5 7 8 10 15 16 19
// 3 4
// 1 2 3
// 1 1 2 4
//
// Output:
// 122
// 8
// Explanation:
// For sample test case 2, the path will be 1 1 2 4 as we can switch between arrays at common elements. In this case
// we'll start from first array and then move to second array to get the maximum sum path.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0599_MaximumSumPath {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int M = in.nextInt(), N = in.nextInt();
            final int[] A1 = new int[M], A2 = new int[N];

            for (int i = 0; i < M; i++) {
                A1[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                A2[i] = in.nextInt();
            }

            printMaximumSumPath(A1, A2);
        }
    }

    private static void printMaximumSumPath(int[] array1, int[] array2) {

        if (array1.length > array2.length) {
            final int[] temp = array1;
            array1 = array2;
            array2 = temp;
        }

        int sum1 = 0, sum2 = 0;
        int maximumSum = 0;

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == array2[i]) {
                maximumSum += Math.max(sum1, sum2) + array1[i];
                sum1 = 0;
                sum2 = 0;
            } else {
                sum1 += array1[i];
                sum2 += array2[i];
            }
        }

        for (int i = array1.length; i < array2.length; i++) {
            sum2 += array2[i];
        }

        maximumSum += Math.max(sum1, sum2);
        System.out.println(maximumSum);
    }
}
