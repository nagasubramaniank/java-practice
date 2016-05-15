// Problem ID: 297. Remove “b” and “ac” from a given string
//
// Given a string, eliminate all “b” and “ac” in the string, replace them in-place and iterate over the string once.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. Each test case contains a string of length N.
//
// Output:
// Print the resultant substring after removing 'b' and 'ac' from string.
//
// Constraints:
// 1 ≤ T ≤ 200
// 1 ≤ N ≤ 200
//
// Example:
// Input:
// 2
// acbac
// aababc
//
// Output:
//
// aaac

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0297_RemovePatterns {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printFilteredString(in.next());
        }
    }

    private static void printFilteredString(final String string) {
        char[] charArray = string.toCharArray();

        int destination = 0;
        for (int source = 0; source < charArray.length; ) {
            if ((source + 1) < charArray.length && charArray[source] == 'a' && charArray[source + 1] == 'c') {
                source += 2;
            } else if (charArray[source] == 'b') {
                source += 1;
            } else {
                charArray[destination++] = charArray[source++];
            }
        }

        System.out.println(new String(charArray, 0, destination));
    }
}
