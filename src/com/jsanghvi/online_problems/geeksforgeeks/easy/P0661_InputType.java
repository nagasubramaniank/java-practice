// Problem ID: 661. Type of input.
//
// Given an input N , print the data type of the input N.
//
// e.g.
// Sequence of digits -- int
// Sequence of digits with a dot -- float
// Sequence of chars  -- string
// Single non-digit char --- char
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N.
//
// Output:
// Print the data type of the input.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ length of input ≤ 100
//
// Example:
// Input:
// 2
// 12
// gfg

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0661_InputType {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printInputType(in.next());
        }
    }

    private static void printInputType(final String input) {
        int digitCount = 0, dotCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == '.') {
                dotCount += 1;
            } else if (character >= '0' && character <= '9') {
                digitCount += 1;
            }
        }

        if (input.length() == digitCount) {
            System.out.println("int");
        } else if (input.length() == 1) {
            System.out.println("char");
        } else if (dotCount == 1 && input.length() == digitCount + 1) {
            System.out.println("float");
        } else {
            System.out.println("string");
        }
    }
}
