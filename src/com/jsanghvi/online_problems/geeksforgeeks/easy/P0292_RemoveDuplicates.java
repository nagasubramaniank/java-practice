// Problem ID: 292. Remove all duplicates from a given string.
//
// Given a string, the task is to remove all  duplicate characters from the string and print the resultant string. The
// order of remaining characters in the output should be same as in the original string.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. Each test case contains a string of length N.
//
// Output:
// Print the resultant substring after removing duplicate characters from string.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100
//
// Example:
// Input:
// 2
// geeksforgeeks
// HappyNewYear
//
// Output:
// geksfor
// HapyNewYr

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0292_RemoveDuplicates {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printWithDuplicatesRemoved(in.next());
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
