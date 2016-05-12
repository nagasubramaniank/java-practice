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
            final int[] A1 = new int[M + 1], A2 = new int[N + 1];

            for (int i = 0; i < M; i++) {
                A1[i] = in.nextInt();
            }
            A1[M] = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                A2[i] = in.nextInt();
            }
            A2[N] = Integer.MAX_VALUE;

            printMaximumSumPath(A1, A2);
        }
    }

    private static void printMaximumSumPath(final int[] array1, final int[] array2) {

        int sumPath1 = 0, sumPath2 = 0;

        for (int i1 = 0, i2 = 0; i1 < array1.length - 1 || i2 < array2.length - 1; ) {
            if (array1[i1] < array2[i2]) {
                sumPath1 += array1[i1++];
            } else if (array2[i2] < array1[i1]) {
                sumPath2 += array2[i2++];
            } else {
                final int value = array1[i1];

                int t1 = 0, t2 = 0;
                for (; array1[i1] == value; i1++, t1++) ;
                for (; array2[i2] == value; i2++, t2++) ;


                sumPath1 = sumPath2 = Math.max(sumPath1, sumPath2) + value * (t1 + t2 - 1);
            }
        }
        System.out.println(Math.max(sumPath1, sumPath2));
    }
}
