// Problem ID: 723. Search pattern.
//
// Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the
// occurrences of pattern string in the text string. For printing, starting Index of a string should be taken as 1.
//
// Note: Strings contain only lower case alphabets.
//
// Input:
// First line of the input contains an integer 'T' denoting the total number of test cases. Then T test cases follow.
// Each test consists of two lines. First line of each test case contains the text string. Second line of each test case
// contains the pattern string.
//
// Output:
// Print indexes all the occurrences of the pattern strings in the text string in a single line separated by spaces.
// Print -1 if no pattern found.
//
// Constraints:
// 1 <= T <= 100
// 1 <= Sizeof of text String <= 10000
// 1 <= Sizeof pattern String <= Sizeof text String
//
// Example:
//
// Input
// 2
// batmanandrobinarebatfriends
// bat
// abcsdu
// edu
//
// Output
// 1 18
// -1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0723_PatternSearch {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printMatchingIndices(in.next(), in.next());
        }
    }

    private static void printMatchingIndices(final String text, final String pattern) {
        final char[] textArray = text.toCharArray(), patternArray = pattern.toCharArray();

        final int[] prefixLengths = getPrefixLengths(patternArray);
        final List<Integer> matches = getMatches(textArray, patternArray, prefixLengths);

        if (matches.size() == 0) {
            System.out.println(-1);
        } else {
            for (final int match : matches) {
                System.out.print(match + " ");
            }
            System.out.println();
        }
    }

    private static int[] getPrefixLengths(final char[] pattern) {
        final int[] prefixLengths = new int[pattern.length];
        int previousPrefixLength = -1;

        for (int i = 0; i < pattern.length; i++) {
            while (previousPrefixLength >= 0 && pattern[i] != pattern[previousPrefixLength]) {
                previousPrefixLength = (previousPrefixLength != 0 ? prefixLengths[previousPrefixLength - 1] : -1);
            }

            prefixLengths[i] = ++previousPrefixLength;
        }

        return prefixLengths;
    }

    private static List<Integer> getMatches(final char[] text, final char[] pattern, final int[] prefixLengths) {
        final List<Integer> matches = new ArrayList<>();
        int previousPrefixLength = 0;

        for (int i = 0; i < text.length; i++) {
            while (previousPrefixLength >= 0 && text[i] != pattern[previousPrefixLength]) {
                previousPrefixLength = (previousPrefixLength != 0 ? prefixLengths[previousPrefixLength - 1] : -1);
            }

            if (++previousPrefixLength == pattern.length) {
                matches.add(i - pattern.length + 2);
                previousPrefixLength = prefixLengths[pattern.length - 1];
            }
        }

        return matches;
    }
}
