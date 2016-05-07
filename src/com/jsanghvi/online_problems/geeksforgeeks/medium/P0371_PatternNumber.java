// Problem ID: 371. Number following a pattern.
//
// Problem Description:
// Given a pattern containing only I's and D's. I for increasing and D for decreasing, devise an algorithm to print the
// minimum number following that pattern. Digits from 1-9 and digits can't repeat.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is a string, which contains only I's and D's in capital letter.
//
// Output:
// Print the minimum number following that pattern.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ Length of String ≤ 8
//
// Example:
// Input
// 5
// D
// I
// DD
// IIDDD
// DDIDDIID
//
// Output
// 21
// 12
// 321
// 126543
// 321654798

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P0371_PatternNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNumberFollowingPattern(in.next());
        }
    }

    private static void printNumberFollowingPattern(final String pattern) {
        List<Integer> digits = new LinkedList<>();
        digits.add(1);

        int behind = 0;
        for (int i = 0; i < pattern.length(); i++) {
            behind = (pattern.charAt(i) == 'I' ? 0 : behind + 1);
            digits.add(digits.size() - behind, i + 2);
        }

        for (int digit : digits) {
            System.out.print(digit);
        }

        System.out.println();
    }
}
