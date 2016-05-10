// Problem ID: 579. Length of the longest substring.
//
// Given a string, find the length of the longest substring without repeating characters. For example, the longest
// substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is str.
//
// Output:
//
// Print the length of longest substring.
//
// Constraints:
//
// 1 ≤ T ≤ 20
// 1 ≤ str ≤ 50
//
// Example:
//
// Input:
// 2
// geeksforgeeks
// qwertqwer
//
// Output:
// 7
// 5

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0579_LongestSubstring {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printLongestStringLength(in.next());
        }
    }

    private static void printLongestStringLength(final String string) {
        final char[] characters = string.toCharArray();
        final Map<Character, Integer> visitedCharacters = new HashMap<>();

        int longestLength = 0;
        for (int left = 0, right = 0; right < characters.length; right++) {
            if (visitedCharacters.containsKey(characters[right])) {
                left = Math.max(left, visitedCharacters.get(characters[right]) + 1);
            }

            visitedCharacters.put(characters[right], right);
            longestLength = Math.max(longestLength, right - left + 1);
        }

        System.out.println(longestLength);
    }
}
