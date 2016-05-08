// Problem ID: 426. Concatenation of Zig-Zag String in ‘n’ Rows.
//
// Given a string and number of rows ‘n’. Print the string formed by concatenating n rows when input string is written
// in row-wise Zig-Zag fashion.
//
// Input:
// The first line of input consists number of the test cases. The description of T test cases is as follows:
// The first line of each test case contains the string, and the second line has 'n' the number of rows.
//
// Output:
// In each separate line print the string after concatenating n rows in a zig zag form.
//
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ size of string
//
// Example:
//
// Input:
// 2
// qrrc
// 3
// rfkqyuqfjkxy
// 2
//
// Output:
// qrcr
// rkyqjxfqufky
//
// Explanation:
// Input: str = "ABCDEFGH", n = 2
// Output: "ACEGBDFH"
//
// Let us write input string in Zig-Zag fashion in 2 rows.
// A   C   E   G
//   B   D   F   H
// Now concatenate the two rows and ignore spaces in every row. We get "ACEGBDFH"
//
// Input: str = "GEEKSFORGEEKS", n = 3
// Output: GSGSEKFREKEOE

// Let us write input string in Zig-Zag fashion in 3 rows.
// G       S       G       S
//   E   K   F   R   E   K
//     E       O       E
// Now concatenate the two rows and ignore spaces in every row. We get "GSGSEKFREKEOE"

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0426_ZigZagString {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printZigZag(in.next(), in.nextInt());
        }
    }

    private static void printZigZag(final String string, final int lines) {
        if (lines <= 1 || lines >= string.length()) {
            System.out.println(string);
            return;
        }

        StringBuilder zigZag = new StringBuilder(string.length());
        for (int line = 0; line < lines; line++) {
            for (int i = 0; ; i += 2 * lines - 2) {
                if (i + line >= string.length()) {
                    break;
                }

                zigZag.append(string.charAt(i + line));

                if (i + 2 * lines - 2 - line >= string.length()) {
                    break;
                }

                if (line != 0 && line != lines - 1) {
                    zigZag.append(string.charAt(i + 2 * lines - 2 - line));
                }
            }
        }

        System.out.println(zigZag);
    }
}
