// Problem 6. Longest Common Subsequence
//
// Given two strings S1 and S2, find the longest common subsequence between S1 and S2.

package com.jsanghvi.algorithms.dynamic_programming;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        printLongestCommonSubsequence("", "");
        printLongestCommonSubsequence("ABABABAB", "");
        printLongestCommonSubsequence("ABABABAB", "AABBAABB");
    }

    private static void printLongestCommonSubsequence(final String string1, final String string2) {
        final int[][] longestSequenceLengths = new int[string1.length() + 1][string2.length() + 1];

        for (int index1 = 0; index1 < string1.length(); index1++) {
            for (int index2 = 0; index2 < string2.length(); index2++) {
                if (string1.charAt(index1) == string2.charAt(index2)) {
                    longestSequenceLengths[index1 + 1][index2 + 1] = longestSequenceLengths[index1][index2] + 1;
                } else {
                    longestSequenceLengths[index1 + 1][index2 + 1]
                            = Math.max(longestSequenceLengths[index1][index2 + 1],
                            longestSequenceLengths[index1 + 1][index2]);
                }
            }
        }

        System.out.println("Input Strings: '" + string1 + "' and '" + string2 + "'.");
        System.out.println("Longest Common Subsequence Length: "
                + longestSequenceLengths[string1.length()][string2.length()]);

        final Deque<Character> stack = new ArrayDeque<>();
        for (int index1 = string1.length() - 1, index2 = string2.length() - 1; index1 > 0 && index2 > 0; ) {
            int longestSequenceLength = longestSequenceLengths[index1 + 1][index2 + 1];
            if (longestSequenceLength == longestSequenceLengths[index1][index2] + 1) {
                stack.push(string1.charAt(index1));
                index1 -= 1;
                index2 -= 1;
            } else if (longestSequenceLength == longestSequenceLengths[index1][index2 + 1]) {
                index1 -= 1;
            } else if (longestSequenceLength == longestSequenceLengths[index1 + 1][index2]) {
                index2 -= 1;
            } else {
                throw new AssertionError("Invalid value found in 'longest sequence lengths' table.");
            }
        }

        System.out.print("Longest Common Subsequence: ");
        stack.forEach(System.out::print);
        System.out.println();
        System.out.println();
    }
}
