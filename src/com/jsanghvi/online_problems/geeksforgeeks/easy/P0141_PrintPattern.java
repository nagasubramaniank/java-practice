// Problem ID: 141. Print Pattern.
//
// Print a sequence of numbers starting with N, without using loop, in which  A[i+1] = A[i] - 5,  if  A[i] > 0, else
// A[i+1] = A[i] + 5. Repeat it until A[i] = N.
//
// Input:
// First line contains number of test cases T. Then following T lines contains an integer N.
//
// Output:
// Single line with pattern.
//
// Constraints:
// 0 < N < 10000
//
// Example:
// Input:
// 2
// 16
// 10
//
// Output:
// 16 11 6 1 -4 1 6 11 16
// 10 5 0 5 10
//
// Explanation:
// We basically first reduce 5 one by one until we reach a negative or 0. After we reach 0 or negative, we one by one
// add 5 until we reach N.


package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0141_PrintPattern {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printPattern(in.nextInt());
        }
    }

    private static void printPattern(final int number) {
        StringBuilder pattern = new StringBuilder();

        int currentNumber;
        for (currentNumber = number; currentNumber > 0; currentNumber -= 5) {
            pattern.append(currentNumber).append(' ');
        }

        for (; currentNumber <= number; currentNumber += 5) {
            pattern.append(currentNumber).append(' ');
        }

        System.out.println(pattern);
    }
}
