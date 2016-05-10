// Problem ID: 88. Anagram.
//
// Given two strings, check whether two given strings are anagram of each other or not. An anagram of a string is
// another string that contains same characters, only the order of characters can be different. For example, “act” and
// “tac” are anagram of each other.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. Each test case consist of two
// strings in 'lowercase' only, in a separate line.
//
// Output:
//
// Print "YES" without quotes if the two strings are anagram else print "NO".
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ |s| ≤ 100
//
// Example:
//
// Input:
// 2
// geeksforgeeks
// forgeeksgeeks
// allergy
// allergic
//
// Output:
// YES
// NO

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0088_Anagram {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printAreAnagrams(in.next(), in.next());
        }
    }

    private static void printAreAnagrams(final String string1, final String string2) {
        final byte[] string1Counts = new byte[26], string2Counts = new byte[26];

        for (int i = 0; i < string1.length(); i++) {
            string1Counts[string1.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < string2.length(); i++) {
            string2Counts[string2.charAt(i) - 'a'] += 1;
        }

        System.out.println(Arrays.equals(string1Counts, string2Counts) ? "YES" : "NO");
    }
}
