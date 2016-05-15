// Problem ID: 350. Amend Sentence.
//
// You are given an array of characters which is basically a sentence. However there is no space between different words
// and the first letter of every word is in uppercase. You need to print this sentence after following amendments:
// (i) Put a single space between these words
// (ii) Convert the uppercase letters to lowercase.
//
// Input:
// The first line of input contains the number of test cases. The description of T test case follows.
// Each test case contains a single line containing a string.
//
// Output:
// Print the desired Sentence.
//
// Constraints:
// 1 <= T <= 30
// 1 <= Size of String <= 100
//
// Example:
//
// Input:
// 2
// BruceWayneIsBatman
// You
//
// Output:
// bruce wayne is batman
// you

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0350_AmendSentence {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printAmendedSentence(in.next());
        }
    }

    private static void printAmendedSentence(final String sentence) {
        StringBuilder amendedSentence = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isUpperCase(sentence.charAt(i))) {
                amendedSentence.append(' ').append(Character.toLowerCase(sentence.charAt(i)));
            } else {
                amendedSentence.append(sentence.charAt(i));
            }
        }

        System.out.println(amendedSentence.toString().trim());
    }
}
