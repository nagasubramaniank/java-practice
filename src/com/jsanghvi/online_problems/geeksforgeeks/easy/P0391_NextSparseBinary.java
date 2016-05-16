// Problem ID: 391. Next sparse binary number.
//
// Given an integer n in the input, find its next sparse binary number.A sparse binary number is a number whose binary
// representation does not contain any consecutive 1s.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The first line of each test case is
// number 'N'
//
// Output:
// Print next Sparse binary number, if the input number is not sparse else print the number itself.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ n ≤ 100000
//
// Example:
//
// Input
// 2
// 3
// 5
//
// Output
// 4
// 5

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0391_NextSparseBinary {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNextSparseBinaryNumber(in.nextInt());
        }
    }

    private static void printNextSparseBinaryNumber(int number) {
        int consecutiveOnes = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if ((number & (1 << bitPosition)) != 0) {
                consecutiveOnes += 1;
            } else {
                if (consecutiveOnes >= 2) {
                    number |= (1 << bitPosition);
                    for (int bitPosition2 = 0; bitPosition2 < bitPosition; bitPosition2++) {
                        number &= ~(1 << bitPosition2);
                    }
                    consecutiveOnes = 1;
                } else {
                    consecutiveOnes = 0;
                }
            }
        }

        System.out.println(number);
    }
}
