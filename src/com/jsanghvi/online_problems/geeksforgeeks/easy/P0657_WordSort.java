// Problem ID: 657. Word sort.
//
// Atul has n number of words. Atul's friend Ankur is interested in the length of those words in increasing order as
// well as the total length of words. Since there are many test cases, help Ankur to obtain his desired result.
//
// Input:
// The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. Each
// test case consist of two lines. First line of test case contain number of words N. Second line of test case contain
// words separated by a single space.
//
// Output:
// For each test case print the length of word in increasing order followed by the total sum separated by a single space.
//
// Constraints:
// 1 <= T <= 100
// 1 <= n <= 20
// 1 <= Length of each word <= 100
//
// Example:
//
// Input:
// 2
// 4
// i am learning strings
// 6
// i am learning strings and arrays
//
// Output:
// 1 2 7 8 18
// 1 2 3 6 7 8 27

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0657_WordSort {
    public static void main(final String args[]) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final String[] words = new String[N];

            for (int i = 0; i < N; i++) {
                words[i] = in.next();
            }

            printSortedWordLengths(words);
        }
    }

    private static void printSortedWordLengths(final String[] words) {
        final int[] lengths = new int[words.length];

        int totalLength = 0;
        for (int i = 0; i < words.length; i++) {
            lengths[i] = words[i].length();
            totalLength += lengths[i];
        }

        Arrays.sort(lengths);
        for (int length : lengths) {
            System.out.print(length + " ");
        }

        System.out.println(totalLength);
    }
}
