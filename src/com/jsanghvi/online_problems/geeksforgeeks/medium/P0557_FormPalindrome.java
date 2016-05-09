// Problem ID: 557. Form a palindrome.
//
// Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
//
// For Example:
// ab: Number of insertions required is 1. bab or aba
// aa: Number of insertions required is 0. aa
// abcd: Number of insertions required is 3. dcbabcd
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is S.
//
// Output:
//
// Print the minimum number of characters.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ S ≤ 40
//
// Example:
//
// Input:
// 3
// abcd
// aba
// geeks
//
// Output:
// 3
// 0
// 3

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0557_FormPalindrome {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printCharactersForPalindrome(in.next());
        }
    }

    private static void printCharactersForPalindrome(final String string) {
        final int size = string.length();
        final int[][] table = new int[size][size];

        for (int length = 2; length <= size; length++) {
            for (int left = 0, right = left + length - 1; right < size; left++, right++) {
                if (string.charAt(left) == string.charAt(right)) {
                    table[left][right] = table[left + 1][right - 1];
                } else {
                    table[left][right] = Math.min(table[left][right - 1], table[left + 1][right]) + 1;
                }
            }
        }
        System.out.println(table[0][size - 1]);
    }
}
