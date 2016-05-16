// Problem ID: 386.
//
// Given a keypad as shown in diagram, and a n digit number, list all words which are possible by pressing these numbers.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the number of digits.
// The second line of each test case contains D[i], N number of digits.
//
// Output:
// Print all possible words from phone digits with single space.
//
// Constraints:
// 1 ≤ T ≤ 10
// 1 ≤ N ≤ 5
// 2 ≤ D[i] ≤ 9
//
// Example:
//
// Input:
// 1
// 3
// 2 3 4
//
// Output:
// adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0386_PossibleWords {
    private static final char[][] letters = new char[][]{
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printPossibleWords(A);
        }
    }

    private static void printPossibleWords(final int[] numbers) {
        StringBuilder output = new StringBuilder();
        printPossibleWords(numbers, "", output);
        System.out.println(output);
    }

    private static void printPossibleWords(final int[] numbers, final String initial, final StringBuilder output) {
        final int currentLength = initial.length();
        if (currentLength == numbers.length) {
            output.append(initial).append(' ');
            return;
        }

        for (char letter : letters[numbers[currentLength]]) {
            printPossibleWords(numbers, initial + letter, output);
        }
    }
}
