// Problem ID: 412. Longest distinct characters in a string.
//
// Given a string, find length of the smallest substring with maximum number of distinct characters.  For example, for
// input "abca", the output is 3 as "abc" is the smallest substring with maximum number of distinct characters.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is String str.
//
// Output:
// Print length of smallest substring with maximum number of distinct characters.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ size of str ≤ 10000
//
// Example:
//
// Input:
// 2
// abababcdefababcdab
// geeksforgeeks
//
// Output:
// 6
// 7

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0412_LongestSubstring {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printLongestSubstring(in.next());
        }
    }

    private static void printLongestSubstring(final String string) {
        Map<Character, Integer> lastPosition = new HashMap<>();

        int substringLength = 0, longestSubstringLength = 0;
        for (int position = 0; position < string.length(); position++) {
            substringLength += 1;
            char character = string.charAt(position);

            if (lastPosition.containsKey(character)) {
                substringLength = Math.min(substringLength, position - lastPosition.get(character));
            }

            lastPosition.put(character, position);
            longestSubstringLength = Math.max(longestSubstringLength, substringLength);
        }

        System.out.println(longestSubstringLength);
    }
}
