// Problem ID: 392. Longest Palindrome in a String.
//
// Given a string S, find the longest palindromic substring in S.
//
// Substring of string S: S[i....j] where 0 ≤ i ≤ j < len(S)
// Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
// In case of conflict, return the substring which occurs first ( with the least starting index ).
//
// Input:
// The first line of input consists number of the test cases. The following T lines consist of a string each.
//
// Output:
// In each separate line print the longest palindrome of the string given in the respective test case.
//
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ str ≤ length of string
//
// Example:
//
// Input:
// 1
// aaaabbaa
//
// Output:
// aabbaa

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0392_LongestPalindrome {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printLongestPalindrome(in.next());
        }
    }

    private static void printLongestPalindrome(final String string) {
        char[] characters = string.toCharArray();
        int longestPalindromeLength = 1;
        int longestPalindromeStart = 0;

        for (int mid = 0; mid < characters.length; mid++) {
            int left, right;
            for (left = mid - 1, right = mid + 1; left >= 0 && right < characters.length; left--, right++) {
                if (characters[left] != characters[right]) {
                    break;
                }

                if (longestPalindromeLength < right - left + 1) {
                    longestPalindromeLength = right - left + 1;
                    longestPalindromeStart = left;
                }
            }

            for (left = mid, right = mid + 1; left >= 0 && right < characters.length; left--, right++) {
                if (characters[left] != characters[right]) {
                    break;
                }

                if (longestPalindromeLength < right - left + 1) {
                    longestPalindromeLength = right - left + 1;
                    longestPalindromeStart = left;
                }
            }
        }

        System.out.println(String.valueOf(characters, longestPalindromeStart, longestPalindromeLength));
    }
}
