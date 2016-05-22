// Problem ID: 511. Special keyboard.
//
// Imagine you have a special keyboard with the following keys:
// Key 1: Prints 'A' on screen
// Key 2: (Ctrl-A): Select screen
// Key 3: (Ctrl-C): Copy selection to buffer
// Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
//
// If you can only press the keyboard for N times (with the above four keys), write a program to produce maximum numbers
// of A's. That is to say, the input parameter is N (No. of keys that you can press), the output is M (No. of As that
// you can produce).
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the number of key.
//
// Output:
// Print maximum number of A's.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 75
//
// Example:
//
// Input:
// 2
// 3
// 7
//
// Output:
// 3
// 9
//
// Explanation:
//
// Input:  N = 3
// Output: 3
// We can at most get 3 A's on screen by pressing following key sequence.
// A, A, A
//
// Input:  N = 7
// Output: 9
// We can at most get 9 A's on screen by pressing following key sequence.
// A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0511_MaximumCharacters {
    public static void main(final String[] args) {
        final int[] maximumCharacters = getMaximumCharacters(75);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            printMaximumCharacters(N, maximumCharacters);
        }
    }

    private static void printMaximumCharacters(final int keystrokes, final int[] maximumCharacters) {
        System.out.println(maximumCharacters[keystrokes]);
    }

    private static int[] getMaximumCharacters(final int maximumKeystrokes) {
        final int[] maximumCharacters = new int[maximumKeystrokes + 1];

        for (int keystrokes = 1; keystrokes <= maximumKeystrokes; keystrokes++) {
            maximumCharacters[keystrokes] = keystrokes;

            // Breakpoint is the key number at which we press Ctrl+A, then we press Ctrl+C and later all Ctrl+Vs
            for (int breakpoint = 1; breakpoint <= keystrokes; breakpoint++) {
                maximumCharacters[keystrokes] = Math.max(maximumCharacters[keystrokes],
                        maximumCharacters[breakpoint - 1] * (keystrokes - breakpoint));
            }
        }

        return maximumCharacters;
    }
}
