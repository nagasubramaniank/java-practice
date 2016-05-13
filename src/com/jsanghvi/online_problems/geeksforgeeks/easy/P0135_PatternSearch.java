// Problem ID: 135. Pattern Searching.
//
// Given a text and a pattern, Find whether the pattern exist in the text or not. If it is present print "found" without
// quotes else print "not found" without quotes.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. Each test case consist of a string
// in 'lowercase' only in a separate line.
//
// Output:
//
// Print "found" or "not found" in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ |s| ≤ 100
//
// Example:
//
// Input
// 1
// geeksforgeeks
// geeks
//
// Output
// found

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0135_PatternSearch {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsPatternFound(in.next(), in.next());
        }
    }

    private static void printIsPatternFound(final String string, final String pattern) {

        // Since this is an easy problem, We will perform a naive pattern search.
        for (int patternPosition = 0; patternPosition <= string.length() - pattern.length(); patternPosition++) {

            int charPosition;
            for (charPosition = 0; charPosition < pattern.length(); charPosition++) {
                if (string.charAt(patternPosition + charPosition) != pattern.charAt(charPosition)) {
                    break;
                }
            }

            if (charPosition == pattern.length()) {
                System.out.println("found");
                return;
            }
        }

        System.out.println("not found");
    }
}
