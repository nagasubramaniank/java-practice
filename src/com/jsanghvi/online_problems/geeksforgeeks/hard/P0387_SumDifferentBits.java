// Problem ID: 387. Find sum of different corresponding bits for all pairs.
//
// We define f (X, Y) as number of different corresponding bits in binary representation of X and Y. For example,
// f (2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit
// differ, so f (2, 7) = 2.
//
// You are given an array of N integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that
// 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.
//
// Input:
//
// The first line of each input consists of the test cases. The description of T test cases is as follows:
//
// The first line of each test case contains the size of the array, and the second line has the elements of the array.
//
//
// Output:
//
// In each separate line print sum of all pairs for (i, j) such that 1 ≤ i, j ≤ N and return the answer modulo 10^9+7.
//
//
// Constraints:
//
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 100
// -2,147,483,648 ≤ A[i] ≤ 2,147,483,647
//
// Example:
//
// Input:
//
// 2
// 2
// 2 4
// 3
// 1 3 5
//
// Output:
//
// 4
// 8
//
// Working:
//
// A = [1, 3, 5]
//
// We return
//
// f(1, 1) + f(1, 3) + f(1, 5) +
// f(3, 1) + f(3, 3) + f(3, 5) +
// f(5, 1) + f(5, 3) + f(5, 5) =
//
// 0 + 1 + 1 +
// 1 + 0 + 2 +
// 1 + 2 + 0 = 8

package com.jsanghvi.online_problems.geeksforgeeks.hard;

import java.util.Scanner;

public class P0387_SumDifferentBits {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printSumDifferentBits(A);
        }
    }

    private static void printSumDifferentBits(final int[] numbers) {

        int sum = 0;

        // For some reason geeksforgeeks does not want us to consider the MSB position.
        for (int bitPosition = 0; bitPosition < 31; bitPosition++) {

            int ones = 0;
            final int andWith = 1 << bitPosition;

            for (final int number : numbers) {
                if ((number & andWith) != 0) {
                    ones += 1;
                }
            }

            sum += 2 * (ones * (numbers.length - ones));
        }

        System.out.println(sum);
    }
}
