// Problem ID: 196. Non Repeating Character.
//
// Given a string s consisting of lowercase Latin Letters, find the first non repeating character in s.
//
// Input:
//
// The first line contains T denoting the number of test cases. Then follows description of test cases.
// Each case begins with a single integer N denoting the length of string. The next line contains the string s.
//
// Output:
//
// For each test case, print the first non repeating character present in string. Print -1 if there is no non repeating
// character.
//
// Constraints:
//
// 1 <= T <= 30
// 1 <= N <= 100
//
// Example:
//
// Input:
// 3
// 5
// hello
// 12
// zxvczbtxyzvy
// 6
// xxyyzz
//
// Output:
// h
// c
// -1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0196_NonRepeatingCharacter {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            in.nextInt();
            printNonRepeatingCharacter(in.next());
        }
    }

    private static void printNonRepeatingCharacter(final String string) {
        int[] characterCount = new int[26];

        for (int i = 0; i < string.length(); i++) {
            characterCount[string.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < string.length(); i++) {
            if (characterCount[string.charAt(i) - 'a'] == 1) {
                System.out.println(string.charAt(i));
                return;
            }
        }

        System.out.println(-1);
    }
}
