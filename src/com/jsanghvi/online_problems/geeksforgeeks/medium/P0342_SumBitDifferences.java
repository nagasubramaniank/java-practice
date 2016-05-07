// Problem ID: 342. Sum of bit differences.
//
// Write a program to find the sum of bit differences in all pairs that can be formed from array elements n. Bit
// difference of a pair (x, y) is a count of different bits at same positions in binary representations of x and y. For
// example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 (first and last bits differ
// in two numbers).
//
// Input: The first line of input contains an integer T denoting the number of test cases. First line of the test case
// will contain an array of elements n.
//
// Output: The sum of bit differences of all pairs that can be formed by given array.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10
// 1 <= a[i] <= 10
//
// Example:
//
// Input:
// 2
// 2
// 1 2
// 3
// 1 3 5
//
// Output:
// 4
// 8

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0342_SumBitDifferences {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printSumOfBitDifferences(A);
        }
    }

    private static void printSumOfBitDifferences(int[] numbers) {
        int sumBitDifferences = 0;

        for (int bitPosition = 0; bitPosition < 4; bitPosition++) {
            final int andWith = 1 << bitPosition;
            int numberOfOnes = 0;

            for (int number : numbers) {
                if ((number & andWith) != 0) {
                    numberOfOnes += 1;
                }
            }

            sumBitDifferences += 2 * numberOfOnes * (numbers.length - numberOfOnes);
        }

        System.out.println(sumBitDifferences);
    }
}
