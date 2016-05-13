// Problem ID: 151. Palindrome Numbers.
//
// Check if binary representation of a number is palindrome
//
// Input:
// The first line contains an integer T, depicting total number of test cases.
// Then following T lines contains an integer N.
//
// Output:
// Each separate line showing output 0(False) or 1 (True).
//
// Constraints:
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 1018
//
// Example:
// Input:
// 2
// 999
// 17
//
// Output:
// 0
// 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0151_PalindromeNumbers {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsPalindrome(in.nextLong());
        }
    }

    private static void printIsPalindrome(final long number) {
        boolean[] bits = new boolean[64];

        int binaryLength = 0;
        for (long remainingNumber = number; remainingNumber > 0; remainingNumber >>>= 1) {
            bits[binaryLength++] = remainingNumber % 2 != 0;
        }

        for (int left = 0, right = binaryLength - 1; left < right; left++, right--) {
            if (bits[left] != bits[right]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
