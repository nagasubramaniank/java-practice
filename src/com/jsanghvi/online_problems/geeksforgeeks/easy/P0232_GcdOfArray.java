// Problem ID: 232. GCD of Array.
//
// For a given array find out the GCD of the array.
//
// Input:
// First line of input contains the number of test cases 'T'. First line of test case contain an the size 'N' of array.
// Second line of test cases contain the array elements.
//
// Output:
// Find GCD and print it in separate line.
//
// Constraints:
// 1 <= T <= 32
// 1 <= N <= 20
// 1 <= Arr[i] <= 100
//
// Example:
//
// Input:
// 1
// 2
// 5 10
//
// Output:
// 5

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0232_GcdOfArray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printGcd(A);
        }
    }

    private static void printGcd(final int[] numbers) {
        int gcd = numbers[0];

        for (int number : numbers) {
            gcd = gcd(gcd, number);
        }

        System.out.println(gcd);
    }

    private static int gcd(final int x, final int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
