// Problem ID: 291. Move all zeroes to end of array.
//
// Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example, if the
// given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is
// number of elements in array 'N' and second its values.
//
// Output:
// Print the array after shifting all 0's at the end.​
//
// Note: An extra space is expected at the end after output of every test case
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 1000
// 0 <= a[i] <= 100
//
// Example:
// Input:
// 1
// 5
// 3 5 0 0 4
//
// Output:
// 3 5 4 0 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0291_BubbleDownZeroes {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printZeroesInEnd(A);
        }
    }

    private static void printZeroesInEnd(final int[] numbers) {
        int countZeroes = 0;
        StringBuilder output = new StringBuilder();

        for (int number : numbers) {
            if (number == 0) {
                countZeroes += 1;
            } else {
                output.append(number).append(' ');
            }
        }

        for (int i = 0; i < countZeroes; i++) {
            output.append("0 ");
        }

        System.out.println(output);
    }
}
