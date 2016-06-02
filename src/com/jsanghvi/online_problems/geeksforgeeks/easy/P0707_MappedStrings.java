// Problem ID: 707. Mapped string.
//
// Given 'N' unique characters (in infinite supply), find the number of possible Mapped strings (P) of length 'N'. A
// Mapped string is one that follows following properties:
//
// a. Both the left and right halves of the string contains unique characters.
// b. Both the left and right halves of the string contains same characters.
//
// For example: “abccba” is Mapped string since the left half (“abc”) do contain the same characters as the right half
// (“cba”).
//
// Input
// The first line contains an integer 'T' denoting the number of test cases. Then 'T' test cases follows. Each test case
// consists of a single line containing a single integer 'N' denoting the number of unique characters.
//
// Output
// For each test case print P modulo 1000000007. (Since the answer could be large so print it modulo 1000000007).
//
// Constraints
// 1 <= T <= 200
// 2 <= N <= 10^6
//
// Note:
// N is always even.
//
// Example:
// INPUT
// 2
// 2
// 8
//
// OUTPUT
// 2
// 40320

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0707_MappedStrings {
    public static void main(final String[] args) {
        final int[] mappedStringCount = getMappedStringCount(1000000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printMappedStringCount(in.nextInt(), mappedStringCount);
        }
    }

    private static void printMappedStringCount(final int characters, final int[] mappedStringCount) {
        System.out.println(mappedStringCount[characters]);
    }

    private static int[] getMappedStringCount(final int maximumCharacters) {
        // Total possible combinations of characters in left half = N! / [(N/2)!]^2.
        // Total possible permutations of each combination in left half = (N/2)!.
        // Total possible permutations of all possible combinations in left half = {N! / [(N/2)!]^2} * (N/2)! = N! / (N/2)!
        // Total possible permitted combinations in right half for each combination in left half = (N/2)!
        // Total possible permitted combinations in right half for all possible combinations in left half = N! / (N/2)! * (N/2)! = N!
        // Hence, solution is simply factorial of available unique characters N.

        final int[] mappedStringCount = new int[maximumCharacters + 1];
        mappedStringCount[0] = 1;
        for (int characters = 1; characters <= maximumCharacters; characters++) {
            mappedStringCount[characters] = (int) (((long) mappedStringCount[characters - 1] * characters) % 1000000007);
        }

        return mappedStringCount;
    }
}
