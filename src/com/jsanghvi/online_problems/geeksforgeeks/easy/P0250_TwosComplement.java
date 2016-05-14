// Problem ID: 250. 2's Complement.
//
// For a given string of binary number find the two’s complement of it.
//
// Input :
// The first line contains an integer 'T' denoting the total number of test cases. The next T lines contains the string S.
//
// Output:
//  In each separate line the two’s complement string should be output.
//
// Constraints:
// 1 <= T <= 30
// 1 <= length(string) <= 10
//
// Example:
// Input:
// 1
// 00000101
//
// Output:
// 11111011

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0250_TwosComplement {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printTwosComplement(in.next());
        }
    }

    private static void printTwosComplement(final String binary) {
        String twosComplement = "";
        boolean invert = false;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) != '0') {
                twosComplement = (invert ? "0" : "1") + twosComplement;
                invert = true;
            } else {
                twosComplement = (invert ? "1" : "0") + twosComplement;
            }
        }

        if (!invert) {
            twosComplement = "1" + twosComplement;
        }

        System.out.println(twosComplement);
    }
}
