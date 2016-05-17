// Problem ID: 424. Replace by X.
//
// Given a string and a pattern, Replace all the continuous occurrence of pattern with a single X in the string. For a
// clear view see the example below.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is string str.
// The second line of each test case contains a string s,which is a pattern.
//
// Output:
// Print the modified string str.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ size of str,s ≤ 1000
//
// Example:
//
// Input:
// 2
// abababcdefababcdab
// ab
// geeksforgeeks
// geeks
//
// Output:
// XcdefXcdX
// XforX

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0424_ReplacePattern {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printReplacedString(in.next(), in.next());
        }
    }

    private static void printReplacedString(final String string, final String pattern) {
        StringBuilder output = new StringBuilder();
        boolean lastReplaced = false;
        for (int i = 0; i < string.length(); ) {

            if (i < string.length() - pattern.length() + 1
                    && string.substring(i, i + pattern.length()).equals(pattern)) {
                if (!lastReplaced) {
                    output.append('X');
                }

                i += pattern.length();
                lastReplaced = true;
            } else {
                output.append(string.charAt(i++));
                lastReplaced = false;
            }
        }

        System.out.println(output);
    }
}
