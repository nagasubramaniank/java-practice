// Problem ID: 288. Check if a given string is a rotation of a palindrome.
//
// Given a string, check if it is a rotation of a palindrome. For example “aab” is a rotation of “aba”.
//
// Input:
// The first line contains T denoting the number of test cases. Then follows description of test cases.
// Each case contains a string.
//
// Output:
// For each test case, output "1" if string is rotation of a palindrome otherwise "0" in a new line.
//
// Constraints:
// 1 <= T <= 50
// 1 <= Length of the string <= 100
//
// Example:
// Input:
// 1
// aab
//
// Output:
// 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0288_PalindromeRotation {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsPalindromeRotation(in.next());
        }
    }

    private static void printIsPalindromeRotation(final String string) {
        final String doubleString = string + string;

        for (int leftStart = string.length() / 2 - 1; leftStart < string.length() + string.length() / 2 - 1;
             leftStart++) {
            boolean isPalindrome = true;
            for (int left = leftStart, right = string.length() % 2 == 0 ? leftStart + 1 : leftStart + 2;
                 right - left < string.length(); left--, right++) {
                if (doubleString.charAt(left) != doubleString.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
