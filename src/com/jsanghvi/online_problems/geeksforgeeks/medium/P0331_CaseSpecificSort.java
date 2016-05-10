// Problem ID: 331. Case-specific Sorting of Strings.
//
// Given a string consisting of uppercase and lowercase characters, you need to sort uppercase and lowercase letters
// separately such that if the ith place in the original string had an Uppercase character then it should not have a
// lowercase character after being sorted and vice versa.
//
// Input: The first line of input contains an integer T denoting the number of test cases. The description of T test
// cases follows.
// The first line of each test case contains a single integer N denoting the length of string.
// The second line contains a string of length N, consisting of uppercase and lowercase characters.
//
// Output: Print T lines consisting of a sorted strings for the particular test case.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 1000
//
// Example:
//
// Input:
// 1
// 12
// defRTSersUXI
//
// Output:
// deeIRSfrsTUX

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P0331_CaseSpecificSort {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            in.nextInt();
            printCaseSorted(in.next());
        }
    }

    private static void printCaseSorted(final String string) {
        List<Character> lowercaseCharacters = new ArrayList<>();
        List<Character> uppercaseCharacters = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (Character.isLowerCase(character)) {
                lowercaseCharacters.add(character);
            } else {
                uppercaseCharacters.add(character);
            }
        }

        Collections.sort(lowercaseCharacters);
        Collections.sort(uppercaseCharacters);

        StringBuilder sortedString = new StringBuilder();

        for (int i = 0, li = 0, ui = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (Character.isLowerCase(character)) {
                sortedString.append(lowercaseCharacters.get(li++));
            } else {
                sortedString.append(uppercaseCharacters.get(ui++));
            }
        }

        System.out.println(sortedString);
    }
}
