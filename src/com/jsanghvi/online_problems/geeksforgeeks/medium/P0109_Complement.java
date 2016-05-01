// Problem ID 109. Complement.
//
// You are given a binary string S. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N
// and complement the characters between L and R i.e SL, SL+1, …, SR. By complement, we mean change character 0 to 1 and
// vice-versa.
//
// You task is to perform AT MOST one operation such that in final string number of 1s is maximised. If there is no need
// to complement, i.e., string contains all 1s, return -1. Else, return the two values denoting L and R. If there are
// multiple solutions, return the lexicographically smallest pair of L and R.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// Each test case consist of a length of string N and the next line contains the string S in 'lowercase' only.
//
// Output:
//
// Print the value L and R with space between then in a separate line if it exists else print -1.
//
// Constraints:
//
// 1 ≤ T ≤ 40
// 1 ≤ N ≤ 100
// 1 ≤ |s| ≤ 100
//
// Example:
//
// Input:
// 2
// 3
// 111
// 2
// 01
//
// Output:
// -1
// 1 1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0109_Complement {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        in.nextLine();

        for (int test = 0; test < T; test++) {
            in.nextLine();
            printComplementPosition(in.nextLine());
        }
    }

    private static void printComplementPosition(final String string) {

        int maximumTill = -1, maximumAll = -1;
        int maximumAllLeft = -1, maximumAllRight = -1;

        for (int left = 0, right = 0; right < string.length(); right++) {
            if (maximumTill < 0) {
                maximumTill = (string.charAt(right) == '0' ? 1 : -1);
                left = right;
            } else {
                maximumTill += (string.charAt(right) == '0' ? 1 : -1);
            }

            if (maximumAll < maximumTill) {
                maximumAll = maximumTill;
                maximumAllLeft = left;
                maximumAllRight = right;
            }
        }

        if (maximumAll < 0) {
            System.out.println(-1);
        } else {
            System.out.println((maximumAllLeft + 1) + " " + (maximumAllRight + 1));
        }
    }
}
