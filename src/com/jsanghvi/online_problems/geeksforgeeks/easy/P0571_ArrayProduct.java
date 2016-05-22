// Problem ID: 571. Product array puzzle.
//
// Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the
// product of all the elements of arr[] except arr[i].
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the size of array.
// The second line of each test case contains N input A[i].
//
// Output:
// Print the Product array prod[].
//
// Constraints:
// 1 ≤ T ≤ 10
// 1 ≤ N ≤ 15
// 1 ≤ C[i] ≤ 20
//
// Example:
//
// Input
// 2
// 5
// 10 3 5 6 2
// 2
// 12 20
//
// Output
// 180 600 360 300 900
// 20 12

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0571_ArrayProduct {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printArrayProduct(A);
        }
    }

    private static void printArrayProduct(final int[] numbers) {
        // Do not compute product of all numbers in array as that would cause long overflow.

        long product = 1;
        for (int i = 1; i < numbers.length; i++) {
            product *= numbers[i];
        }

        StringBuilder output = new StringBuilder();
        output.append(product).append(' ');

        for (int i = 1; i < numbers.length; i++) {
            product /= numbers[i];
            product *= numbers[i - 1];
            output.append(product).append(' ');
        }

        System.out.println(output);
    }
}
