// Problem ID: 284. Isomorphic Strings.
//
// Check if two given strings are isomorphic to each other.Two strings str1 and str2 are called isomorphic if there is a
// one to one mapping possible for every character of str1 to every character of str2. And all occurrences of every
// character in ‘str1′ map to same character in ‘str2′.
//
// Input:
// The first line contains an integer T, depicting total number of test cases. Each test case contains two strings each
// in new line.
//
// Output:
// Print "1" if strings are isomorphic and "0" if not.
//
// Constraints:
// 1 <= T <= 100
// 1 <= Length of Strings <= 1000
//
// Example:
// Input:
// 2
// aab
// xxy
// aab
// xyz
//
// Output:
// 1
// 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0284_IsomorphicString {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsIsomorphic(in.next(), in.next());
        }
    }

    private static void printIsIsomorphic(final String string1, final String string2) {

        if (string1.length() != string2.length()) {
            System.out.println(0);
            return;
        }

        final Map<Character, Character> mapping1 = new HashMap<>(), mapping2 = new HashMap<>();

        for (int i = 0; i < string1.length(); i++) {
            final Character char1 = string1.charAt(i), char2 = string2.charAt(i);

            if (!mapping1.containsKey(char1) && !mapping2.containsKey(char2)) {
                mapping1.put(char1, char2);
                mapping2.put(char2, char1);
            } else if (!mapping1.containsKey(char1) || !mapping1.get(char1).equals(char2)
                    || !mapping2.containsKey(char2) || !mapping2.get(char2).equals(char1)) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
