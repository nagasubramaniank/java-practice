// Problem ID: 182. Consecutive Elements.
//
// For a given string delete the elements which are appearing more than once consecutively. All letters are of lowercase.
//
// Input:
//
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases,  a string will be
// inserted.
//
// Output:
// In each separate line the modified string should be output.
//
// Constraints:
// 1 <= T <= 31
// 1 <= length(string) <= 100
//
// Example:
//
// Input:
// 1
// aababbccd
//
// Output:
// ababcd

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0182_ConsecutiveElements {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printWithoutConsecutiveElements(in.next());
        }
    }

    private static void printWithoutConsecutiveElements(final String string) {
        StringBuilder output = new StringBuilder();

        for (char previousElement = 0, i = 0; i < string.length(); i++) {
            char element = string.charAt(i);
            if (element != previousElement) {
                output.append(element);
                previousElement = element;
            }
        }

        System.out.println(output);
    }
}
