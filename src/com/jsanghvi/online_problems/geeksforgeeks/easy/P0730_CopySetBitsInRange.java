// Problem ID: 730. Copy set bits in range.
//
// Given two numbers x and y, and a range [l, r] where 1 <= l, r <= 32. The task is consider set bits of y in range
// [l, r] and set these bits in x also.
//
// For example, if x = 10, y = 13, l = 2, r = 3,  the program should change x to 14. Binary representation of 10 is 1010
// and that of y is 1101. There is one set bit in y at 3’rd position (in given range). After we copy this bit to x, x
// becomes 1110 which is binary representation of 14.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. Each test case contains space
// separated values of x, l, r and y in a single line.
//
// Output:
// Print modified value of x.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ x ≤ 10000
// 1 ≤ l, r ≤ 32
// 1 ≤ y ≤ 10000
//
// Example:
//
// Input:
// 2
// 44 1 5 3
// 16 1 3 2
//
// Output:
// 47
// 18

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0730_CopySetBitsInRange {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printModifiedValue(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private static void printModifiedValue(final int target, final int left, final int right, final int source) {
        System.out.println(target | (source & (((1L << (Math.max(right - left + 1, 0))) - 1) << (left - 1))));
    }
}
