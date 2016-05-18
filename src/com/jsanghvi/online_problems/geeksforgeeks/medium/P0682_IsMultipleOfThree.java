// Problem ID: 682. Is binary number multiple of 3.
//
// Given a binary number,  write a program that prints 1 if given binary number is a multiple of 3.  Else prints 0. The
// given number can be big up to 2^100. It is recommended to finish the task using one traversal of input binary string.
//
// Input:
// The first line contains T denoting the number of test cases. Then follows description of test cases.
// Each case contains a string containing 0's and 1's.
//
// Output:
// For each test case, output a 1 if string is multiple of 3, else 0.
//
// Constraints:
// 1 <= T <= 100
// 1 <= Length of Input String <= 100
//
// Example:
//
// Input:
// 2
// 1001
// 100
//
// Output:
// 1
// 0

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0682_IsMultipleOfThree {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsMultipleOfThree(in.next());
        }
    }

    private static void printIsMultipleOfThree(final String string) {
        int oddEvenDifference = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '0') {
                oddEvenDifference += (i % 2 == 0 ? 1 : -1);
            }
        }

        System.out.println(oddEvenDifference % 3 == 0 ? 1 : 0);
    }
}
