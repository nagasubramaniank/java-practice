// Problem ID: 462. Remove duplicates.
//
// Given a string, remove duplicates from it. Note that original order of characters must be kept same. Expected time
// complexity O(n) where n is length of input string and extra space O(1) under the assumption that there are total 256
// possible characters in a string.
//
// Input:
// First line of the input is the number of test cases T. And first line of test case contains a string.
//
// Output:
// Modified string without duplicates and same order of characters.
//
// Constraints:
// Input String Length <= 1000
//
// Example:
//
// Input:
// 2
// geeksforgeeks
// geeks for geeks
//
// Output:
// geksfor
// geks for

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0462_RemoveDuplicates {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        in.nextLine();

        for (int test = 0; test < T; test++) {
            printWithDuplicatesRemoved(in.nextLine());
        }
    }

    private static void printWithDuplicatesRemoved(final String string) {
        final Set<Character> appearedCharacters = new HashSet<>();
        final StringBuilder output = new StringBuilder(string.length());

        for (int i = 0; i < string.length(); i++) {
            final char character = string.charAt(i);
            if (!appearedCharacters.contains(character)) {
                output.append(character);
                appearedCharacters.add(character);
            }
        }

        System.out.println(output);
    }
}
