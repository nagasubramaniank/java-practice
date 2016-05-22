// Problem ID: 548. Make number odd.
//
// Given a number n. Print the minimum positive integer by which it should be divided so that the result is an odd
// number.
//
// Input:
// First line of the input will contain the number of test cases. Each test case will contain a single integer n.
//
// Output:
// Print the required output.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100000
//
// Example:
//
// Input:
// 3
// 36
// 5
// 8
//
// Output:
// 4
// 1
// 8
//
// Explanation:
// In the first case, 36 must be divided by 4 or 12 to make it odd.
// We take minimum of 4 and 12 i.e. 4
// In the second case, 5 is already odd.
// In the third case, 8 must be divided by 8 to make it an odd number.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0548_MakeOddNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printDivisor(in.nextInt());
        }
    }

    private static void printDivisor(final int number) {
        int divisor = 1;
        for (int remainingNumber = number; remainingNumber % 2 == 0; remainingNumber /= 2) {
            divisor *= 2;
        }

        System.out.println(divisor);
    }
}
