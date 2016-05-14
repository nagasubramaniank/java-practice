// Problem ID: 236. Distinct Substrings.
//
// Given a string S consisting of uppercase alphabetic characters. Return the  number of different substrings of size 2
// that appear in S as contiguous substrings.
//
// Input:
// The first line contains 'T' denoting the number of test cases. Then follows description of test cases. The next T
// lines contains the string S.
//
// Output:
// Output the number of different substrings of size 2 in S.
//
// Constraints:
// 1<=T<=50
// 1<=|S|<=100
//
// Example:
// Input:
// 2
// ABCAB
// XYZ
//
// Output:
// 3
// 2
//
// Explanation:
// For "ABCAB", the three distinct substrings of size 2 are "AB", "BC" and "CA". For "XYZ", the two distinct substrings
// of size 2 are "XY" and "YZ".

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0236_DistinctSubstrings {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printDistinctSubstrings(in.next());
        }
    }

    private static void printDistinctSubstrings(final String string) {

        int distinctSubstrings = 0;
        final Set<String> substrings = new HashSet<>();

        for (int i = 0; i < string.length() - 1; i++) {
            final String substring = string.substring(i, i + 2);
            if (!substrings.contains(substring)) {
                substrings.add(substring);
                distinctSubstrings += 1;
            }
        }

        System.out.println(distinctSubstrings);
    }
}
