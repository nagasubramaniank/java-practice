// Problem ID: 259. Count occurrences of Anagrams.
//
// Given a word and a text, return the count of the occurrences of anagrams of the word in the text(For eg: anagrams of
// word for are for, ofr, rof etc.))
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows.
// The first line of each test case contains a text  consisting of only lowercase Latin Letters.
// The second line contains a word consisting of only lowercase Latin Letters.
//
// Output:
// Print the count of the occurrences of anagrams of the word in the text.
//
// Constraints:
// 1 <= T <= 50
// 1 <= |word|<= |text| <= 50
// here |word| denotes the size of word and |text| denotes the size of text
//
// Example:
// Input:
// 2
// forxxorfxdofr
// for
// aabaabaa
// aaba
//
// Output:
// 3
// 4
//
// Explanation:
// for, orf and ofr appears in the first test case and hence answer is 3.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0259_CountAnagrams {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printAnagramCount(in.next(), in.next());
        }
    }

    private static void printAnagramCount(final String text, final String word) {
        final int[] textCharacterCounts = new int[26], wordCharacterCounts = new int[26];

        for (int i = 0; i < word.length(); i++) {
            wordCharacterCounts[word.charAt(i) - 'a'] += 1;
        }

        int anagramCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (i >= word.length()) {
                textCharacterCounts[text.charAt(i - word.length()) - 'a'] -= 1;
            }

            textCharacterCounts[text.charAt(i) - 'a'] += 1;
            if (i >= word.length() - 1) {
                if (Arrays.equals(textCharacterCounts, wordCharacterCounts)) {
                    anagramCount += 1;
                }
            }
        }

        System.out.println(anagramCount);
    }
}
